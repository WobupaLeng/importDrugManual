package com.electric.manual.common.constant;

import java.util.concurrent.atomic.AtomicInteger;

public enum LikeIngredientAttr implements SingleIntEnum {
    ATTR3(10, "主要成份")
    , ATTR4(10, "主要成分")
    , ATTR5(10, "本品主要成分")
    , ATTR6(10, "本品主要成份")
    , ATTR7(10, "成份")
    , ATTR8(10, "成分")
    ;

    private final int value;
    private final String name;

    LikeIngredientAttr(int value, String name) {
        this.value = value;
        this.name = name;
    }

    public static int getIndex(String str) {
        AtomicInteger i = new AtomicInteger(-1);
        AttrInitConstant.getIngredientAttrs().parallelStream().forEach(s -> {
            int index = str.indexOf(s.getName());
            //这里按匹配内容决定位置 取靠前的
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
