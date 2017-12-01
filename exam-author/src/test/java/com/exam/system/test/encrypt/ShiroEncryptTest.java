package com.exam.system.test.encrypt;

import org.apache.shiro.codec.Hex;
import org.apache.shiro.crypto.AesCipherService;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.security.Key;

/**
 * @packageName：com.exam.system.test.encrypt
 * @desrciption: shiro加密解密
 * @author: gaowei
 * @date： 2017-11-30 17:24
 * @history: (version) author date desc
 */
public class ShiroEncryptTest {

    private static final Logger log = LoggerFactory.getLogger(ShiroEncryptTest.class);


    /**
     * AES 加密算法
     */
    @Test
    public void encryptTest() {
        AesCipherService aesCipherService = new AesCipherService();
        // 设置加密key长度
        aesCipherService.setKeySize(128);

        Key key = aesCipherService.generateNewKey();
        String code = "password";
        String encryptCode = aesCipherService.encrypt(code.getBytes(), key.getEncoded()).toHex();
        log.debug("加密：{}", encryptCode);

        String dencryptCode = new String(aesCipherService.decrypt(Hex.decode(encryptCode), key.getEncoded()).getBytes());
        log.debug("解密：{}", dencryptCode);
    }

    /**
     * AES 加密算法
     */
    @Test
    public void dencryptTest() {
        AesCipherService aesCipherService = new AesCipherService();
        // 设置加密key长度
        aesCipherService.setKeySize(128);

        Key key = aesCipherService.generateNewKey();
        String code = "1498e92095b6d8f160eff8642998c5a27db6cbfac0d9d27b72db1cd8f7bdccf3";
        String encryptCode = new String(aesCipherService.decrypt(Hex.decode(code), key.getEncoded()).getBytes());
        log.debug("解密：{}", encryptCode);
    }
}
