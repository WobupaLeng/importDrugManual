package com.electric.manual.pasring.strategy.execute;

import com.electric.manual.common.constant.DrugManualAttr;
import com.electric.manual.common.constant.LikeIngredientAttr;
import com.electric.manual.pasring.strategy.AttrStrategy;

public class IngredientAttrStrategy implements AttrStrategy {
    @Override
    public int getIndex(String text, DrugManualAttr drugManualAttr) {
        int index = -1;
        for (LikeIngredientAttr attr : LikeIngredientAttr.values()) {
            index = text.indexOf(attr.getName());
            if (index > 0) {
                break;
            }
        }
        return index;
    }
}
