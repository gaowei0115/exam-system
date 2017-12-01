package com.exam.system.test.baseCode;

import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @packageName：com.exam.system.test.baseCode
 * @desrciption: salt加密
 * @author: gaowei
 * @date： 2017-11-30 16:57
 * @history: (version) author date desc
 */
public class SaltCodeTest {

    private static final Logger log = LoggerFactory.getLogger(SaltCodeTest.class);

    @Test
    public void saltMd5Encode() {
        String code = "password";
        String salt = "123";
        String md5Code = new Md5Hash(code, salt).toString();
        log.debug("加密：{}", md5Code);
    }

    @Test
    public void saltSha256Encode() {
        String code = "password";
        String salt = "123";
        String sha256Code = new Sha256Hash(code, salt).toString();
        log.debug("加密：{}", sha256Code);
    }
}
