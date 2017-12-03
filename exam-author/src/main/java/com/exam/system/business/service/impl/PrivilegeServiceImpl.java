package com.exam.system.business.service.impl;

import com.exam.system.business.entity.PrivilegeEntity;
import com.exam.system.business.service.PrivilegeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @packageName：com.exam.system.business.service.impl
 * @desrciption: 权限管理Service
 * @author: gaowei
 * @date： 2017/12/2 19:39
 * @history: (version) author date desc
 */
@Service("privilegeService")
public class PrivilegeServiceImpl  implements PrivilegeService{

    /**
     * logger
     */
    private static final Logger log = LoggerFactory.getLogger(PrivilegeServiceImpl.class);

    @Override
    public void savePrivilege(PrivilegeEntity entity) {

    }

    @Override
    public int updatePrivilege(PrivilegeEntity entity) {
        return 0;
    }

    @Override
    public int deletePrivilege(Long privilegeId) {
        return 0;
    }

    @Override
    public List<PrivilegeEntity> queryPrivilegeList() {
        return null;
    }

    @Override
    public PrivilegeEntity queryPrivilege(Long privilegeId) {
        return null;
    }
}
