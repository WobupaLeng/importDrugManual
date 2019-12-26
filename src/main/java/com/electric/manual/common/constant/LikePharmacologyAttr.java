package com.electric.manual.common.constant;

public enum LikePharmacologyAttr implements SingleIntEnum {
    ATTR1(17, "药理毒理")
    , ATTR2(17, "药理药毒")
    , ATTR3(17, "药理作用")
    , ATTR4(17, "毒理研究")
    ;

    private final int value;
    private final String name;

    LikePharmacologyAttr(int value, String name) {
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
        index = str.indexOf(ATTR3.getName());
        if (index > 0)
            return index;
        return str.indexOf(ATTR4.getName());
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
