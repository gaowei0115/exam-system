package com.exam.system.common.core.shiro.service.impl;

import com.exam.system.common.core.shiro.service.ShiroManager;
import com.exam.system.common.log.impl.CommonLogger;
import com.exam.system.common.utils.IniFileUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.filter.mgt.DefaultFilterChainManager;
import org.apache.shiro.web.filter.mgt.PathMatchingFilterChainResolver;
import org.apache.shiro.web.servlet.AbstractShiroFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.util.Map;
import java.util.Set;

/**
 * @packageName：com.exam.system.common.shiro.service.impl
 * @desrciption: 权限管理器实现类
 * @author: gaowei
 * @date： 2017/11/26 16:47
 * @history: (version) author date desc
 */
public class ShiroManagerImpl implements ShiroManager {

    /**
     * logger
     */
    private static final CommonLogger log = new CommonLogger(ShiroManagerImpl.class);

    /**
     * 默认ini配置
     */
    private static final String DEFAULT_SECTION = "ini_auth";

    private static final String CRLF = "\r\n";

    @Autowired
    private ShiroFilterFactoryBean factoryBean;

    /**
     * ini配置文件路径
     */
    private String iniPath;
    private String section;

    @Override
    public String loadFilterChainDefinitions() {
        StringBuffer sb = new StringBuffer();
        // 使用固定权限加载
        sb.append(loadFixAuthRule());
        return sb.toString();
    }

    @Override
    public void reloadFilterChains() {
        // 获取过滤器对象
        AbstractShiroFilter shiroFilter = null;

        try {
            shiroFilter = (AbstractShiroFilter) factoryBean.getObject();
            
        } catch (Exception e) {
            log.error(String.format("获取shiroFilter from shiroFilterFactoryBean error!"), e);
            throw new RuntimeException("获取 shiroFilter from shiroFilterFactoryBean error!");
        }

        PathMatchingFilterChainResolver filterChainResolver = (PathMatchingFilterChainResolver) shiroFilter.getFilterChainResolver();

        DefaultFilterChainManager filterChainManager = (DefaultFilterChainManager) filterChainResolver.getFilterChainManager();

        // 清空老权限
        filterChainManager.getFilterChains().clear();

        factoryBean.getFilterChainDefinitionMap().clear();
        // 重新加载权限
        factoryBean.setFilterChainDefinitions(loadFilterChainDefinitions());

        Map<String, String> chains = factoryBean.getFilterChainDefinitionMap();
        for (String key : chains.keySet()) {
            String value = chains.get(key);
            String chainDefinition = value.trim().replace(" ", "");
            filterChainManager.createChain(key, chainDefinition);
        }

    }

    /**
     * 加载配置文件中的权限
     * @return
     */
    private String loadFixAuthRule() {

        if (StringUtils.isBlank(this.iniPath)) {
            log.error("ini配置文件为空，请查看spring shiro配置...");
            throw new IllegalArgumentException("ini配置文件为空，请查看spring shiro配置");
        }
        ClassPathResource cp = new ClassPathResource(this.iniPath);

        IniFileUtils iniFileUtils = null;
        try {
            iniFileUtils = new IniFileUtils(cp.getFile());
        } catch (IOException e) {
            log.error("加载ini配置文件【file={}】出错", this.iniPath);
        }
        if (StringUtils.isBlank(section)) {
            this.section = DEFAULT_SECTION;
        }
        Set<String> keys = iniFileUtils.get(section).keySet();
        StringBuffer sb = new StringBuffer();
        for (String key : keys) {
            String value = iniFileUtils.get(section, key);
            sb.append(key).append(" = ")
                    .append(value).append(CRLF);
        }

        return sb.toString();
    }

    /**
     * 设置inipat路径
     * @param iniPath
     */
    public void setIniPath(String iniPath) {
        this.iniPath = iniPath;
    }

    /**
     * 设置ini配置文件起始位置
     * @param section
     */
    public void setSection(String section) {
        this.section = section;
    }

    /**
     *
     * @param factoryBean
     */
    public void setFactoryBean(ShiroFilterFactoryBean factoryBean) {
        this.factoryBean = factoryBean;
    }
}
