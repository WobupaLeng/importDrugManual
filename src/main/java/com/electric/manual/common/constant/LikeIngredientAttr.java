package com.electric.manual.common.constant;

public enum LikeIngredientAttr implements SingleIntEnum {
    ATTR5(10, "本品主要成分")
    , ATTR6(10, "本品主要成份")
    , ATTR3(10, "主要成份")
    , ATTR4(10, "主要成分")
    , ATTR7(10, "成份")
    , ATTR8(10, "成分")
    ;

    private final int value;
    private final String name;

    LikeIngredientAttr(int value, String name) {
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
