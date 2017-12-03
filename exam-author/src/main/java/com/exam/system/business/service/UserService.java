package com.exam.system.business.service;

import com.exam.system.business.entity.PrivilegeEntity;
import com.exam.system.business.entity.RoleEntity;
import com.exam.system.business.entity.UserEntity;

import java.util.List;
import java.util.Set;

/**
 * @packageName：com.exam.system.business.service
 * @desrciption: 用户操作Service接口
 * @author: gaowei
 * @date： 2017/12/2 16:46
 * @history: (version) author date desc
 */
public interface UserService {

    /**
     * 保存用户
     * @param entity
     * @return
     */
    void saveUser(UserEntity entity);

    /**
     * 更新角色
     * @param entity
     * @return
     */
    int updateUser(UserEntity entity);

    /**
     * 删除用户
     * @param userId
     * @return
     */
    int deleteUser(Long userId);

    /**
     * 查询所有用户信息
     * @return
     */
    List<UserEntity> queryUserList();

    /**
     * 根据ID查询用户信息
     * @param userId
     * @return
     */
    UserEntity queryUser(Long userId);

    /**
     * 建立用户与角色之间的关系，即：一个用户对应多个角色
     * @param userId
     * @param roleIds
     */
    void createUserToRole(Long userId, List<Long> roleIds);


    /**
     * 解除用户与角色之间的关系
     * @param userId
     * @param userIds
     */
    void releaseRoleToPrivilege(Long userId, List<Long> userIds);

    /**
     * 查询用户角色
     * @param userId
     * @return
     */
    Set<RoleEntity> queryRolesByUserId(Long userId);

    /**
     * 查询用户权限
     * @param userId
     * @return
     */
    Set<PrivilegeEntity> queryPrivilegesByUserId(Long userId);
}
