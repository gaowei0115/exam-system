package com.exam.system.test.baseCode;

import org.apache.shiro.codec.Hex;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @packageName：com.exam.system.test.baseCode
 * @desrciption: hex加密
 * @author: gaowei
 * @date： 2017-11-30 16:49
 * @history: (version) author date desc
 */
public class HexEncodeTest {

    private static final Logger log = LoggerFactory.getLogger(HexEncodeTest.class);

    /**
     * 加密
     */
    @Test
    public void testEncode() {
        String code = "password";
        String encode = Hex.encodeToString(code.getBytes());
        log.debug("加密：{}", encode);
    }

    /**
     * 解密
     */
    @Test
    public void testDecode() {
        String code = "70617373776f7264";
        byte[] codeByte = Hex.decode(code);
        String decode = new String(codeByte);
        log.debug("解密：{}", decode);
    }
}
