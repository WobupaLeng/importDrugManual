package com.electric.manual.pasring.strategy;

import com.electric.manual.common.constant.DrugManualAttr;

public class Context {
    public int getIndex(String text, Integer type) {
        AttrStrategy attrStrategy = StrategyFactory.getInstance().creator(type);
        return attrStrategy.getIndex(text, DrugManualAttr.valueOf(type));
    }
}
