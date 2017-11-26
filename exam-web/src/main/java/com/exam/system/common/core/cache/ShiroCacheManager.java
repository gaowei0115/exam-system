package com.exam.system.common.core.cache;

import org.apache.shiro.cache.Cache;

/**
 * @packageName：com.exam.system.common.core.cache
 * @desrciption: shiro自定义缓存管理器接口 ,可以通过实现此接口实现对权限的缓存管理，如redis、HCahce方案
 * @author: gaowei
 * @date： 2017/11/26 21:43
 * @history: (version) author date desc
 */
public interface ShiroCacheManager {

    /**
     * 获取缓存信息
     * @param name
     * @param <K>
     * @param <V>
     * @return
     */
    <K, V> Cache<K, V> getCache(String name);

    /**
     * 销毁
     */
    void destory();
}
