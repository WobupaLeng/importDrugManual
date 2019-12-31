package com.electric.manual.common.constant;

public enum LikeTabooAttr implements SingleIntEnum {
    ATTR2(23, "禁忌")
    , ATTR1(23, "禁忌症")
    ;

    private final int value;
    private final String name;

    LikeTabooAttr(int value, String name) {
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
