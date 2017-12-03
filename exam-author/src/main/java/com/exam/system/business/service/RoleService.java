package com.exam.system.business.service;

import com.exam.system.business.entity.PrivilegeEntity;
import com.exam.system.business.entity.RoleEntity;

import java.util.List;

/**
 * @packageName：com.exam.system.business.service
 * @desrciption: 角色管理Service
 * @author: gaowei
 * @date： 2017/12/2 16:40
 * @history: (version) author date desc
 */
public interface RoleService {

    /**
     * 保存角色
     * @param entity
     * @return
     */
    void saveRole(RoleEntity entity);

    /**
     * 更新角色
     * @param entity
     * @return
     */
    int updateRole(RoleEntity entity);

    /**
     * 删除角色
     * @param roleId
     * @return
     */
    int deleteRole(Long roleId);

    /**
     * 查询所有角色
     * @return
     */
    List<RoleEntity> queryRoleList();

    /**
     * 根据ID查询角色
     * @param roleId
     * @return
     */
    RoleEntity queryRole(Long roleId);

    /**
     * 建立角色与权限之间的关系，即：一个角色对应多个权限
     * @param roleId
     * @param privilegeIds
     */
    void createRoleToPrivilege(Long roleId, List<Long> privilegeIds);


    /**
     * 解除角色与权限之间的关系
     * @param roleId
     * @param privilegeIds
     */
    void releaseRoleToPrivilege(Long roleId, List<Long> privilegeIds);

    /**
     * 根据角色id查询对应的权限信息
     * @param roleId
     * @return
     */
    List<PrivilegeEntity> queryPrivilegesByRoleId(Long roleId);

}
