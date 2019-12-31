package com.electric.manual.pasring.strategy.execute;

import com.electric.manual.common.constant.DrugManualAttr;
import com.electric.manual.common.constant.LikeTabooAttr;
import com.electric.manual.pasring.strategy.AttrStrategy;

public class TabooAttrStrategy implements AttrStrategy {
    @Override
    public int getIndex(String text, DrugManualAttr drugManualAttr) {
        //优先匹配attr1
        int index = text.indexOf(LikeTabooAttr.ATTR1.getName());
        if (index > 0)
            return index;
        return text.indexOf(LikeTabooAttr.ATTR2.getName());
    }
}
