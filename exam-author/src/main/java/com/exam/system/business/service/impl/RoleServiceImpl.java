package com.exam.system.business.service.impl;

import com.exam.system.business.entity.PrivilegeEntity;
import com.exam.system.business.entity.RoleEntity;
import com.exam.system.business.service.RoleService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @packageName：com.exam.system.business.service.impl
 * @desrciption: 角色管理Service
 * @author: gaowei
 * @date： 2017/12/2 19:40
 * @history: (version) author date desc
 */
@Service("roleService")
public class RoleServiceImpl implements RoleService {

    @Override
    public void saveRole(RoleEntity entity) {

    }

    @Override
    public int updateRole(RoleEntity entity) {
        return 0;
    }

    @Override
    public int deleteRole(Long roleId) {
        return 0;
    }

    @Override
    public List<RoleEntity> queryRoleList() {
        return null;
    }

    @Override
    public RoleEntity queryRole(Long roleId) {
        return null;
    }

    @Override
    public void createRoleToPrivilege(Long roleId, List<Long> privilegeIds) {

    }

    @Override
    public void releaseRoleToPrivilege(Long roleId, List<Long> privilegeIds) {

    }

    @Override
    public List<PrivilegeEntity> queryPrivilegesByRoleId(Long roleId) {
        return null;
    }
}
