package com.electric.manual.pasring.strategy.execute;

import com.electric.manual.common.constant.DrugManualAttr;
import com.electric.manual.pasring.strategy.AttrStrategy;

public class PackAttrStrategy implements AttrStrategy {
    @Override
    public int getIndex(String text, DrugManualAttr attr) {
        int index;
        int urlIndex = text.indexOf(DrugManualAttr.IMAGES_URL.getName());
        int packIndex = text.lastIndexOf(DrugManualAttr.PACK.getName());
        if (packIndex <= urlIndex) {
            index = -1;
        } else {
            index = packIndex;
        }
        return index;
    }
}
