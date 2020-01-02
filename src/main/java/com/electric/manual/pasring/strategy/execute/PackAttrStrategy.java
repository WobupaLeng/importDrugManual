package com.electric.manual.pasring.strategy.execute;

import com.electric.manual.common.constant.DrugManualAttr;
import com.electric.manual.pasring.strategy.AttrStrategy;

public class PackAttrStrategy implements AttrStrategy {
    @Override
    public int getIndex(String text, DrugManualAttr attr) {
        int urlIndex = text.indexOf(DrugManualAttr.IMAGES_URL.getName());
        int packIndex = text.lastIndexOf(DrugManualAttr.PACK.getName());
        return packIndex <= urlIndex ? -1 : packIndex;
    }
}
