package com.electric.manual.common.constant;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class AttrInitConstant {
    public static List<LikeTabooAttr> getTabooAttrs() {
        return Arrays.stream(LikeTabooAttr.values()).collect(Collectors.toList());
    }

    public static List<LikeIndicationAttr> getIndicationAttrs() {
        return Arrays.stream(LikeIndicationAttr.values()).collect(Collectors.toList());
    }

    public static List<LikePharmacologyAttr> getPharmacologyAttrs() {
        return Arrays.stream(LikePharmacologyAttr.values()).collect(Collectors.toList());
    }

    public static List<LikeCommonNameAttr> getCommonNameAttrs() {
        return Arrays.stream(LikeCommonNameAttr.values()).collect(Collectors.toList());
    }

    public static List<LikeCompanyNameAttr> getCompanyNameAttrs() {
        return Arrays.stream(LikeCompanyNameAttr.values()).collect(Collectors.toList());
    }

    public static List<LikeChemicalNameAttr> getChemicalNameAttrs() {
        return Arrays.stream(LikeChemicalNameAttr.values()).collect(Collectors.toList());
    }

    public static List<LikeIngredientAttr> getIngredientAttrs() {
        return Arrays.stream(LikeIngredientAttr.values()).collect(Collectors.toList());
    }
}
