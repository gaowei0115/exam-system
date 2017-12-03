package com.exam.system.business.service;

import com.exam.system.business.entity.PrivilegeEntity;

import java.util.List;

/**
 * @packageName：com.exam.system.business.service
 * @desrciption: 权限管理Service接口
 * @author: gaowei
 * @date： 2017/12/2 16:35
 * @history: (version) author date desc
 */
public interface PrivilegeService {

    /**
     * 保存权限
     * @param entity
     * @return
     */
    void savePrivilege(PrivilegeEntity entity);

    /**
     * 更新权限
     * @param entity
     * @return
     */
    int updatePrivilege(PrivilegeEntity entity);

    /**
     * 删除权限
     * @param privilegeId
     * @return
     */
    int deletePrivilege(Long privilegeId);

    /**
     * 查询所有权限
     * @return
     */
    List<PrivilegeEntity> queryPrivilegeList();

    /**
     * 根据ID查询权限
     * @param privilegeId
     * @return
     */
    PrivilegeEntity queryPrivilege(Long privilegeId);

}
