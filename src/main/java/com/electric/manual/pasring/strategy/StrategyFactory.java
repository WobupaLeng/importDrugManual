package com.electric.manual.pasring.strategy;

import com.electric.manual.common.constant.DrugManualAttr;
import com.electric.manual.pasring.strategy.execute.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class StrategyFactory {
    private static StrategyFactory factory = new StrategyFactory();

    private StrategyFactory() {
    }

    private static Map<Integer, AttrStrategy> strategyMap = new HashMap<>();
    //有别名的属性对应的 值
    private static int[] aliasAttr = new int[]{2, 9, 10, 16, 17, 23, 31,35};

    static {
        strategyMap.put(0, new OrdinaryAttrStrategy());
        strategyMap.put(DrugManualAttr.COMMON_NAME.getValue(), new CommonMameAttrStrategy());
        strategyMap.put(DrugManualAttr.CHEMICAL_NAME.getValue(), new ChemicalNameAttrStrategy());
        strategyMap.put(DrugManualAttr.INGREDIENT.getValue(), new IngredientAttrStrategy());
        strategyMap.put(DrugManualAttr.INDICATION.getValue(), new IndicationAttrStrategy());
        strategyMap.put(DrugManualAttr.PHARMACOLOGY.getValue(), new PharmacologyAttrStrategy());
        strategyMap.put(DrugManualAttr.TABOO.getValue(), new TabooAttrStrategy());
        strategyMap.put(DrugManualAttr.COMPANY_NAME.getValue(), new CompanyNameAttrStrategy());
        strategyMap.put(DrugManualAttr.PACK.getValue(), new PackAttrStrategy());
    }

    public AttrStrategy creator(int type) {
        if (Arrays.stream(aliasAttr).noneMatch(s -> s == type))
            return strategyMap.get(0);
        return strategyMap.get(type);
    }

    public static StrategyFactory getInstance() {
        return factory;
    }
}
