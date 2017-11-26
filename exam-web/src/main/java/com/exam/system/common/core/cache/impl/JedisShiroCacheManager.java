package com.exam.system.common.core.cache.impl;

import com.exam.system.common.core.cache.JedisManager;
import com.exam.system.common.core.cache.ShiroCacheManager;
import org.apache.shiro.cache.Cache;

/**
 * @packageName：com.exam.system.common.core.cache.impl
 * @desrciption:
 * @author: gaowei
 * @date： 2017/11/26 22:07
 * @history: (version) author date desc
 */
public class JedisShiroCacheManager implements ShiroCacheManager{

    private JedisManager jedisManager;

    @Override
    public <K, V> Cache<K, V> getCache(String name) {
        return null;
    }

    @Override
    public void destory() {

    }
}
