package com.electric.manual.common.constant;

import java.util.concurrent.atomic.AtomicInteger;

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
        AtomicInteger i = new AtomicInteger(-1);
        AttrInitConstant.getIndicationAttrs().parallelStream().forEach(s -> {
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
