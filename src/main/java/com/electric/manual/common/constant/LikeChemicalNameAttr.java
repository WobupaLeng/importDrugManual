package com.electric.manual.common.constant;

public enum LikeChemicalNameAttr implements SingleIntEnum {
    ATTR1(9, "主要成分及其化学名称")
    , ATTR2(9, "主要成份及其化学名称")
    , ATTR9(9, "本品化学名称为")
    , ATTR3(9, "化学名称")
    ;

    private final int value;
    private final String name;

    LikeChemicalNameAttr(int value, String name) {
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
