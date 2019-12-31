package com.electric.manual.common.constant;

public enum LikeCompanyNameAttr implements SingleIntEnum {
    ATTR1(35, "企业名称")
    , ATTR3(35, "生产厂家")
    ;

    private final int value;
    private final String name;

    LikeCompanyNameAttr(int value, String name) {
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
