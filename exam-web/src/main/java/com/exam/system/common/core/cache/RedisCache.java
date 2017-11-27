package com.exam.system.common.core.cache;

import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;

import java.util.Collection;
import java.util.Set;

/**
 * @packageName：com.exam.system.common.core.cache
 * @desrciption: redis实现Shiro缓存
 * @author: gaowei
 * @date： 2017-11-27 10:49
 * @history: (version) author date desc
 */
public class RedisCache<K, V> implements Cache<K, V>{

    /**
     * Shiro redis 缓存前缀
     */
    private static final String REDIS_CACHE_PREFIX = "shiro_redis_cache";

    private JedisManager jedisManager;

    private String name;

    /**
     * @param name
     * @param jedisManager
     */
    public RedisCache(String name, JedisManager jedisManager) {
        this.name = name;
        this.jedisManager = jedisManager;
    }

    /**
     * 自定义relm中的授权/认证的类名加上授权/认证英文名字
     */
    public String getName() {
        if (name == null) {
            return "";
        }
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    @Override
    public V get(K k) throws CacheException {
        return null;
    }

    @Override
    public V put(K k, V v) throws CacheException {
        return null;
    }

    @Override
    public V remove(K k) throws CacheException {
        return null;
    }

    @Override
    public void clear() throws CacheException {

    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public Set<K> keys() {
        return null;
    }

    @Override
    public Collection<V> values() {
        return null;
    }
}
