package com.exam.system.test.common.utils;

import com.exam.system.business.entity.UserEntity;
import com.exam.system.common.utils.PasswordHelper;
import org.junit.Test;

/**
 * @packageName：com.exam.system.test.common.utils
 * @desrciption: 密码加密工具类测试
 * @author: gaowei
 * @date： 2017/12/2 20:48
 * @history: (version) author date desc
 */
public class PasswordHelperTest {

    @Test
    public void test() {
        PasswordHelper ph = new PasswordHelper();
        UserEntity userEntity = new UserEntity();
        userEntity.setUserPsw("123456");
        userEntity.setLoginName("testpassword");
        ph.encryptPassword(userEntity);
        System.out.println(userEntity.getUserPsw());
    }
}
