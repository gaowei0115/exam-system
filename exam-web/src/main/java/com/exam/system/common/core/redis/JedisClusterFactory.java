package com.exam.system.common.core.redis;

import com.exam.system.common.log.impl.OtherLogger;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.configuration.event.ConfigurationEvent;
import org.apache.commons.configuration.event.ConfigurationListener;
import org.apache.commons.configuration.reloading.FileChangedReloadingStrategy;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.springframework.beans.BeansException;
import org.springframework.beans.TypeConverter;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

/**
 * @packageName：com.exam.system.common.utils
 * @desrciption: redis集群
 * @author: gaowei
 * @date： 2017-11-17 15:47
 * @history: (version) author date desc
 */
public class JedisClusterFactory implements FactoryBean<JedisCluster>, InitializingBean, BeanFactoryAware{

    /**
     * logger
     */
    private static final OtherLogger logger = new OtherLogger(JedisClusterFactory.class);
    /**
     * 地址配置加载
     */
    private Resource addressConfig;
    /**
     * 配置文件
     */
    private PropertiesConfiguration configLoad;
    protected volatile JedisCluster jedisCluster;
    private JedisCluster jedisClusterProxy;
    private volatile boolean isConfigLoad = false;
    private Pattern p = Pattern.compile("^.+[:]\\d{1,5}\\s*(;.+[:]\\d{1,5}\\s*)*[;]?\\s*$");
    private ConfigurableListableBeanFactory beanFactory;
    private final long reloadTime = 5000L;
    private Thread checkFile;

    /**
     *
     */
    public JedisClusterFactory() {
    }



    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = (ConfigurableListableBeanFactory)beanFactory;
    }

    @Override
    public JedisCluster getObject() throws Exception {
        return this.jedisClusterProxy;
    }

    @Override
    public Class<?> getObjectType() {
        return this.jedisClusterProxy != null ? this.jedisClusterProxy.getClass() : JedisCluster.class;
    }

    public void setAddressConfig(String addressConfig) throws ConfigurationException, IOException {
        PathMatchingResourcePatternResolver patternResolver = new PathMatchingResourcePatternResolver();
        Resource resource = patternResolver.getResource(addressConfig);
        this.addressConfig = resource;
    }

    public void setIsConfigLoad(boolean isConfigLoad) {
        this.isConfigLoad = isConfigLoad;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        // 加载配置文件
        final PropertiesConfiguration config = new PropertiesConfiguration(this.addressConfig.getURL());
        FileChangedReloadingStrategy reloadStrategy = new FileChangedReloadingStrategy();

        if (this.isConfigLoad) {
            reloadStrategy.setRefreshDelay(5000L);
            config.setReloadingStrategy(reloadStrategy);
            config.addConfigurationListener(new ConfigurationListener() {
                @Override
                public void configurationChanged(ConfigurationEvent event) {
                    logger.debug("jedis 配置文件产生了变更");
                    try {
                        JedisClusterFactory.this.reloadCluster();
                    } catch (Exception var3) {
                        logger.debug("jedis 配置变更失败", var3);
                    }

                }
            });
            this.checkFile = new Thread(new Runnable() {

                @Override
                public void run() {
                    while(true) {
                        try {
                            config.reload();
                            Thread.sleep(5000L);
                        } catch (InterruptedException var2) {
                            var2.printStackTrace();
                        }
                    }
                }
            });
            this.checkFile.setDaemon(true);
            this.checkFile.start();
        }

        this.configLoad = config;
        this.reloadCluster();
        this.jedisClusterProxy = JedisClusterFactory.JedisClusterInvocation.createJedisClusterProxy(this);
    }

    private void reloadCluster() throws Exception {
        JedisCluster oldCluster = this.jedisCluster;

        try {
            JedisClusterFactory.ConnectRedisConfig redisConfig = this.loadRedisConfig();
            logger.info(String.format("JedisCluster配置加载 %s", redisConfig.toString()));
            Set<HostAndPort> haps = this.parseHostAndPort(redisConfig.address);
            GenericObjectPoolConfig goPConfig = new GenericObjectPoolConfig();
            goPConfig.setMaxWaitMillis(redisConfig.maxWaitMillis);
            goPConfig.setMaxTotal(redisConfig.maxTotal);
            goPConfig.setMinIdle(redisConfig.minIdle);
            goPConfig.setMaxIdle(redisConfig.maxIdle);
            JedisCluster newCluster = new JedisCluster(haps, redisConfig.timeout, redisConfig.maxRedirections, goPConfig);
            this.jedisCluster = newCluster;
        } finally {
            if (oldCluster != null) {
                oldCluster.close();
            }

        }

    }

    private JedisClusterFactory.ConnectRedisConfig loadRedisConfig() throws IllegalArgumentException, IllegalAccessException {
        TypeConverter converter = this.beanFactory.getTypeConverter();
        JedisClusterFactory.ConnectRedisConfig crc = new JedisClusterFactory.ConnectRedisConfig();
        Field[] fields = JedisClusterFactory.ConnectRedisConfig.class.getDeclaredFields();
        Field[] arr$ = fields;
        int len$ = fields.length;

        for(int i$ = 0; i$ < len$; ++i$) {
            Field field = arr$[i$];
            String fieldString = this.configLoad.getString(field.getName());
            if (fieldString != null && !fieldString.isEmpty()) {
                Object fieldVal = converter.convertIfNecessary(fieldString, field.getType());
                field.set(crc, fieldVal);
            }
        }

        return crc;
    }

    private Set<HostAndPort> parseHostAndPort(String addressContent) throws Exception {
        try {
            if (StringUtils.isBlank(addressContent)) {
                throw new IllegalArgumentException("redis 连接地址配置不合法");
            } else {
                boolean result = this.p.matcher(addressContent).matches();
                if (!result) {
                    throw new IllegalArgumentException("redis 连接地址配置不合法");
                } else {
                    Set<HostAndPort> haps = new HashSet();
                    String[] addressArrays = addressContent.split(";");
                    String[] arr$ = addressArrays;
                    int len$ = addressArrays.length;

                    for(int i$ = 0; i$ < len$; ++i$) {
                        String address = arr$[i$];
                        String[] ipAndPort = address.trim().split(":");
                        String ip = ipAndPort[0].trim();
                        String port = ipAndPort[1].trim();
                        HostAndPort hap = new HostAndPort(ip, Integer.parseInt(port));
                        haps.add(hap);
                    }

                    return haps;
                }
            }
        } catch (IllegalArgumentException var13) {
            throw var13;
        } catch (Exception var14) {
            throw new Exception("解析 jedis 配置文件失败", var14);
        }
    }


    public static class JedisClusterInvocation extends JedisCluster implements MethodInterceptor {
        private JedisClusterFactory jcFactory;

        public JedisClusterInvocation() {
            super(new HashSet());
        }

        public JedisClusterInvocation(JedisClusterFactory jcFactory) {
            this();
            this.jcFactory = jcFactory;
        }

        public static JedisCluster createJedisClusterProxy(JedisClusterFactory jcFactory) {
            JedisClusterFactory.JedisClusterInvocation jcI = new JedisClusterFactory.JedisClusterInvocation(jcFactory);
            Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(JedisClusterFactory.JedisClusterInvocation.class);
            enhancer.setCallback(jcI);
            enhancer.setClassLoader(JedisCluster.class.getClassLoader());
            return (JedisCluster)enhancer.create();
        }

        @Override
        public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
            return method.invoke(this.jcFactory.jedisCluster, args);
        }
    }

    /**
     * redis配置文件配置项
     */
    private static class ConnectRedisConfig {
        String address;
        long maxWaitMillis;
        int maxTotal;
        int minIdle;
        int maxIdle;
        int timeout;
        int maxRedirections;

        private ConnectRedisConfig() {
            this.maxWaitMillis = -1L;
            this.maxTotal = 8;
            this.minIdle = 0;
            this.maxIdle = 8;
            this.timeout = 2000;
        }

        @Override
        public String toString() {
            return "ConnectRedisConfig [\n address=" + this.address + ",\n maxWaitMillis=" + this.maxWaitMillis + ", maxTotal=" + this.maxTotal + ", minIdle=" + this.minIdle + ", maxIdle=" + this.maxIdle + ", timeout=" + this.timeout + ", maxRedirections=" + this.maxRedirections + "]";
        }
    }
}


