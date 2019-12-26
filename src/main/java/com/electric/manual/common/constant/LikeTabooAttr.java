package com.electric.manual.common.constant;

public enum LikeTabooAttr implements SingleIntEnum {
    ATTR1(23, "禁忌症")
    , ATTR2(23, "禁忌")
    ;

    private final int value;
    private final String name;

    LikeTabooAttr(int value, String name) {
        this.value = value;
        this.name = name;
    }

    public static int getIndex(String str) {
        //优先匹配attr1
        int index = str.indexOf(ATTR1.getName());
        if (index > 0)
            return index;
        return str.indexOf(ATTR2.getName());
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
