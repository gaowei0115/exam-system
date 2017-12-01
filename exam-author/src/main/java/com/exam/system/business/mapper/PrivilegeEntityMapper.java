package com.exam.system.business.mapper;

import com.exam.system.business.entity.PrivilegeEntity;

public interface PrivilegeEntityMapper {
    int deleteByPrimaryKey(Long privilegeId);

    int insert(PrivilegeEntity record);

    int insertSelective(PrivilegeEntity record);

    PrivilegeEntity selectByPrimaryKey(Long privilegeId);

    int updateByPrimaryKeySelective(PrivilegeEntity record);

    int updateByPrimaryKey(PrivilegeEntity record);
}