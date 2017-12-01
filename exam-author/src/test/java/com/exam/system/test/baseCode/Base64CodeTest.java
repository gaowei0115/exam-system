package com.exam.system.test.baseCode;

import org.apache.shiro.codec.Base64;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * @packageName：com.exam.system.test.baseCode
 * @desrciption: Base64编码测试
 * @author: gaowei
 * @date： 2017-11-30 16:41
 * @history: (version) author date desc
 */
public class Base64CodeTest {

    private static final Logger log = LoggerFactory.getLogger(Base64CodeTest.class);

    /**
     * 加密测试
     */
    @Test
    public void testBase64Encode() {
        String code = "password";
        String encodeCode = Base64.encodeToString(code.getBytes());
        log.debug("加密：{}", encodeCode);
    }

    /**
     * 解密测试
     */
    @Test
    public void testBase64Dencode() {
        String decode = "cGFzc3dvcmQ=";
        String decodeCode = Base64.decodeToString(decode.getBytes());
        log.debug("解密：{}", decodeCode);
    }

}
