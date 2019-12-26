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

    public static int getIndex(String str) {
        int index = str.indexOf(ATTR1.getName());
        if (index > 0)
            return index;
        index = str.indexOf(ATTR2.getName());
        if (index > 0)
            return index;
        return str.indexOf(ATTR3.getName());
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
