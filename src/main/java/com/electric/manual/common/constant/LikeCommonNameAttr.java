package com.electric.manual.common.constant;

import java.util.concurrent.atomic.AtomicInteger;

public enum LikeCommonNameAttr implements SingleIntEnum {
    ATTR1(2, "通用名")
    , ATTR2(2, "通用名称")
    ;

    private final int value;
    private final String name;

    LikeCommonNameAttr(int value, String name) {
        this.value = value;
        this.name = name;
    }

    public static int getIndex(String str) {
        AtomicInteger i = new AtomicInteger(-1);
        AttrInitConstant.getCommonNameAttrs().parallelStream().forEach(s -> {
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
