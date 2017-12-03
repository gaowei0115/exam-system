package com.exam.system.common.utils;

import com.exam.system.business.entity.UserEntity;
import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;

/**
 * @packageName：com.exam.system.common.utils
 * @desrciption: 密码加密工具类
 * @author: gaowei
 * @date： 2017/12/2 20:31
 * @history: (version) author date desc
 */
public class PasswordHelper {

    /**
     * 加密随机salt（盐值）
     */
    private RandomNumberGenerator randomNumberGenerator = new SecureRandomNumberGenerator();

    /**
     * 加密算法
     */
    private final String algorithmName = "MD5";

    /**
     * 加密次数
     */
    private final int hashIterations = 1024;

    /**
     * 加密
     * @param userEntity
     */
    public void encryptPassword(UserEntity userEntity) {
        // 设置账户盐值（salt）
        userEntity.setSalt(randomNumberGenerator.nextBytes().toHex());

        // 加密密码
        String password = new SimpleHash(algorithmName,
                userEntity.getUserPsw(), userEntity.getCredentialsSalt(),
                hashIterations).toHex();
        userEntity.setUserPsw(password);
    }
}
