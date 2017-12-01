package com.exam.system.test.baseCode;

import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.DefaultHashService;
import org.apache.shiro.crypto.hash.HashRequest;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.apache.shiro.util.SimpleByteSource;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @packageName：com.exam.system.test.baseCode
 * @desrciption: shiro提供加密服务测试
 * @author: gaowei
 * @date： 2017-11-30 17:03
 * @history: (version) author date desc
 */
public class ShiroCodeTest {

    private static final Logger log = LoggerFactory.getLogger(ShiroCodeTest.class);

    @Test
    public void simpleHashTest() {
        String code = "password";
        String salt = "123";
        /**
         * 入参：
         * SHA-256，标识使用加密算法，SHA-1，SHA-256
         */
        SimpleHash hash = new SimpleHash("SHA-256", code, salt);
        log.debug("加密：{}", hash.toString());
    }

    @Test
    public void defaultHashServiceTest() {
        DefaultHashService hashService = new DefaultHashService();// 默认使用SHA-512算法
        hashService.setHashAlgorithmName("SHA-256");
        // 私salt 默认为空
        hashService.setPrivateSalt(new SimpleByteSource("123"));
        // 是否生成公salt 默认为false
        hashService.setGeneratePublicSalt(true);
        // 用于生成公sale 默认SecureRandomNumberGenerator
        hashService.setRandomNumberGenerator(new SecureRandomNumberGenerator());
        // 生成hash迭代次数
        hashService.setHashIterations(2);

        HashRequest request = new HashRequest.Builder().setAlgorithmName("MD5").setSource(ByteSource.Util.bytes("password")).setSalt(ByteSource.Util.bytes("123")).setIterations(2).build();

        String encode = hashService.computeHash(request).toHex();
        log.debug("加密：{}", encode);
    }
}
