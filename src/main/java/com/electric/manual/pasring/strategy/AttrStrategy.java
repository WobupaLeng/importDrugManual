package com.electric.manual.pasring.strategy;

import com.electric.manual.common.constant.DrugManualAttr;

public interface AttrStrategy {
    public int getIndex(String text, DrugManualAttr drugManualAttr);
}
