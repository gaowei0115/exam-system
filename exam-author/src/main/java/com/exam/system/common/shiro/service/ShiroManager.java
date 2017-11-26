package com.exam.system.common.shiro.service;

/**
 * @packageName：com.exam.system.common.shiro.service
 * @desrciption: 自定义shiro权限管理器
 * @author: gaowei
 * @date： 2017/11/26 16:45
 * @history: (version) author date desc
 */
public interface ShiroManager {

    /**
     * 加载过滤ini基础配置信息
     * @return
     */
    String loadFilterChainDefinitions();

    /**
     * 重新构建权限过滤器
     * 一般在修改了用户角色、用户等信息时，需要再次调用该方法
     */
    void reloadFilterChains();
}

