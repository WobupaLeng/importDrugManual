package com.electric.manual.common.constant;

import java.util.concurrent.atomic.AtomicInteger;

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
        AtomicInteger i = new AtomicInteger(-1);
        AttrInitConstant.getPharmacologyAttrs().parallelStream().forEach(s -> {
            int index = str.indexOf(s.getName());
            if (index > i.get()) {
                i.set(index);
            }
        });
        return i.get();
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
