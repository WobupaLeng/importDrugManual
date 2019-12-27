package com.electric.manual.common.constant;

import java.util.concurrent.atomic.AtomicInteger;

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

    public static int getIndex(String str) {
        AtomicInteger i = new AtomicInteger(-1);
        AttrInitConstant.getChemicalNameAttrs().parallelStream().forEach(s -> {
            int index = str.indexOf(s.getName());
            if (index < i.get() && index > 0) {
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
