package com.electric.manual.pasring.strategy.execute;

import com.electric.manual.common.constant.AliasAttrInitConstant;
import com.electric.manual.common.constant.DrugManualAttr;
import com.electric.manual.pasring.strategy.AttrStrategy;

import java.util.concurrent.atomic.AtomicInteger;

public class IndicationAttrStrategy implements AttrStrategy {
    @Override
    public int getIndex(String text, DrugManualAttr drugManualAttr) {
        AtomicInteger i = new AtomicInteger(-1);
        AliasAttrInitConstant.getIndicationAttrs().parallelStream().forEach(s -> {
            int index = text.indexOf(s.getName());
            if (index > i.get()) {
                i.set(index);
            }
        });
        return i.get();
    }
}
