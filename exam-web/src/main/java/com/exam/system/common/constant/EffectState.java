package com.exam.system.common.constant;

/**
 * @packageName：com.exam.system.common.constant
 * @desrciption: 生效标识
 * @author: gaowei
 * @date： 2017/11/20 21:05
 * @history: (version) author date desc
 */
public enum EffectState {

    EFFECT_SUCCESS("0", "生效"),
    EFFECT_FAIL("1", "失效");

    /**
     * 生效状态 0：生效、1：失效
     */
    private final String state;
    private final String desc;

    private EffectState(String state_i, String desc_i) {
        this.state = state_i;
        this.desc = desc_i;
    }

    public String getState() {
        return state;
    }

    public String getDesc() {
        return desc;
    }
}
