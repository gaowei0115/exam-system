package com.exam.system.business.service.impl;

import com.exam.system.business.entity.PrivilegeEntity;
import com.exam.system.business.entity.RoleEntity;
import com.exam.system.business.entity.UserEntity;
import com.exam.system.business.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

/**
 * @packageName：com.exam.system.business.service.impl
 * @desrciption: 用户管理Service
 * @author: gaowei
 * @date： 2017/12/2 19:41
 * @history: (version) author date desc
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Override
    public void saveUser(UserEntity entity) {

    }

    @Override
    public int updateUser(UserEntity entity) {
        return 0;
    }

    @Override
    public int deleteUser(Long userId) {
        return 0;
    }

    @Override
    public List<UserEntity> queryUserList() {
        return null;
    }

    @Override
    public UserEntity queryUser(Long userId) {
        return null;
    }

    @Override
    public void createUserToRole(Long userId, List<Long> roleIds) {

    }

    @Override
    public void releaseRoleToPrivilege(Long userId, List<Long> userIds) {

    }

    @Override
    public Set<RoleEntity> queryRolesByUserId(Long userId) {
        return null;
    }

    @Override
    public Set<PrivilegeEntity> queryPrivilegesByUserId(Long userId) {
        return null;
    }
}
