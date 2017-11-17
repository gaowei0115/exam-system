package com.exam.system.common.constant;

/**
 * @packageName：com.exam.system.common.constant
 * @desrciption: 页面交互状态枚举
 * @author: gaowei
 * @date： 2017-11-17 15:03
 * @history: (version) author date desc
 */
public enum ResultState {

    SUCCESS(0, "成功"),
    FAIL(1, "失败");

    private final int state;
    private final String desc;

    private ResultState(int state_i, String desc_i) {
        this.state = state_i;
        this.desc = desc_i;
    }

    public int getState() {
        return state;
    }

    public String getDesc() {
        return desc;
    }
}
