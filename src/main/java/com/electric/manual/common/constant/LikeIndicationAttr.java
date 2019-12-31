package com.electric.manual.common.constant;

public enum LikeIndicationAttr implements SingleIntEnum {
    ATTR1(16, "适应症")
    , ATTR2(16, "功能主治")
    , ATTR3(16, "适用症")
    ;

    private final int value;
    private final String name;

    LikeIndicationAttr(int value, String name) {
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
