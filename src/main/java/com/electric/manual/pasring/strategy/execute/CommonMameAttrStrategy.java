package com.electric.manual.pasring.strategy.execute;

import com.electric.manual.common.constant.DrugManualAttr;
import com.electric.manual.common.constant.LikeCommonNameAttr;
import com.electric.manual.pasring.strategy.AttrStrategy;

public class CommonMameAttrStrategy implements AttrStrategy {
    @Override
    public int getIndex(String text, DrugManualAttr drugManualAttr) {
        int index = -1;
        for (LikeCommonNameAttr attr : LikeCommonNameAttr.values()) {
            index = text.indexOf(attr.getName());
            if (index > 0) {
                break;
            }
        }
        return index;
    }
}
