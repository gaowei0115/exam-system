package com.exam.system.common.core.cache;

import com.exam.system.common.log.impl.CommonLogger;
import org.apache.shiro.cache.Cache;
import redis.clients.jedis.JedisCluster;

/**
 * @packageName：com.exam.system.common.core.cache
 * @desrciption: redis缓存管理器
 * @author: gaowei
 * @date： 2017/11/26 22:08
 * @history: (version) author date desc
 */
public class JedisManager{

    /**
     * logger
     */
    private static final CommonLogger log = new CommonLogger(JedisManager.class);

    /**
     * jedis操作对象
     */
    private JedisCluster jedisCluster;

    /**
     * 默认缓存失效时间
     */
    private static final int DEFAULT_EXPIRE = 60;

    /**
     * 查询缓存中信息
     * @param key
     * @return
     */
    public  byte[] get(byte[] key) throws Exception {
        try {
            return jedisCluster.get(key);
        } catch (Exception e) {
            log.error("redis查询数据异常", e);
            throw e;
        }
    }

    /**
     * 保存redis缓存对象
     * @param key
     * @param value
     * @param expireTime
     */
    public void save(byte[] key, byte[] value, int expireTime) throws Exception {
        try {
            // 保存
            jedisCluster.set(key, value);
            // 设置过期时间
            jedisCluster.expire(key, expireTime);
        } catch (Exception e) {
            log.error("redis执行保存数据异常", e);
            throw e;
        }
    }

    /**
     * 保存redis缓存对象
     * @param key
     * @param value
     */
    public void save(byte[] key, byte[] value) throws Exception {
        save(key, value, DEFAULT_EXPIRE);
    }

    /**
     * 删除
     * @param key
     */
    public void delete(byte[] key) throws Exception {
        try {
            jedisCluster.del(key);
        } catch (Exception e) {
            log.error("redis执行删除异常", e);
            throw e;
        }
    }

    /**
     * 注入JedisCluster
     * @param jedisCluster
     */
    public void setJedisCluster(JedisCluster jedisCluster) {
        this.jedisCluster = jedisCluster;
    }
}
