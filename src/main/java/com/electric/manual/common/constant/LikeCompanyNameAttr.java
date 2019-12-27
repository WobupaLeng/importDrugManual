package com.electric.manual.common.constant;

import java.util.concurrent.atomic.AtomicInteger;

public enum LikeCompanyNameAttr implements SingleIntEnum {
    ATTR1(35, "企业名称")
    , ATTR2(35, "生产企业")
    , ATTR3(35, "生产厂家")
    ;

    private final int value;
    private final String name;

    LikeCompanyNameAttr(int value, String name) {
        this.value = value;
        this.name = name;
    }

    public static int getIndex(String str) {
        AtomicInteger i = new AtomicInteger(-1);
        AttrInitConstant.getCompanyNameAttrs().parallelStream().forEach(s -> {
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
