package com.exam.system.common.core.cache.impl;

import com.exam.system.common.core.cache.ShiroCacheManager;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.util.Destroyable;

/**
 * @packageName：com.exam.system.common.core.cache.impl
 * @desrciption: 自定义缓存管理器
 * @author: gaowei
 * @date： 2017/11/26 21:46
 * @history: (version) author date desc
 */
public class CustomShiroCacheManager implements CacheManager, Destroyable{

    private ShiroCacheManager shiroCacheManager;

    @Override
    public <K, V> Cache<K, V> getCache(String s) throws CacheException {
        return getShiroCacheManager().getCache(s);
    }

    @Override
    public void destroy() {
        getShiroCacheManager().destory();
    }

    /**
     *
     * @return
     */
    public ShiroCacheManager getShiroCacheManager() {
        return this.shiroCacheManager;
    }

    /**
     *
     * @param shiroCacheManager
     */
    public void setShiroCacheManager(ShiroCacheManager shiroCacheManager) {
        this.shiroCacheManager = shiroCacheManager;
    }
}
