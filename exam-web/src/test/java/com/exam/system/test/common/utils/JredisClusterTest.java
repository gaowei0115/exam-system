package com.exam.system.test.common.utils;

import com.exam.system.test.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import redis.clients.jedis.JedisCluster;

/**
 * @packageName：com.exam.system.test.common.utils
 * @desrciption: redis配置测试
 * @author: gaowei
 * @date： 2017-11-17 16:26
 * @history: (version) author date desc
 */
public class JredisClusterTest extends BaseTest{

    @Autowired
    private JedisCluster jedisCluster;

    @Test
    public void test() {
        jedisCluster.set("key1", "value1");
    }

    @Test
    public void get() {
        System.out.println(jedisCluster.get("key1"));
    }
}
