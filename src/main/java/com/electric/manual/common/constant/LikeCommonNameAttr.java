package com.electric.manual.common.constant;

public enum LikeCommonNameAttr implements SingleIntEnum {
    ATTR2(2, "通用名称")
    , ATTR1(2, "通用名")
    ;

    private final int value;
    private final String name;

    LikeCommonNameAttr(int value, String name) {
        this.value = value;
        this.name = name;
    }

    @Override
    public int getValue() {
        return value;
    }

    @Override
    public String getName() {
        return name;
    }
}
