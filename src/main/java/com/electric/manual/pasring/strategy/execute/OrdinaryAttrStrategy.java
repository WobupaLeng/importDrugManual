package com.electric.manual.pasring.strategy.execute;

import com.electric.manual.common.constant.DrugManualAttr;
import com.electric.manual.pasring.strategy.AttrStrategy;

public class OrdinaryAttrStrategy implements AttrStrategy {
    @Override
    public int getIndex(String text, DrugManualAttr attr) {
        return text.indexOf(attr.getName());
    }
}


