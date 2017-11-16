package com.exam.system.manager.system.mapper;

import com.exam.system.manager.system.entity.UserBaseEntity;

public interface UserBaseMapper {
    int insert(UserBaseEntity record);

    int insertSelective(UserBaseEntity record);
}