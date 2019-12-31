package com.electric.manual.common.constant;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class AliasAttrInitConstant {
    public static List<LikeIndicationAttr> getIndicationAttrs() {
        return Arrays.stream(LikeIndicationAttr.values()).collect(Collectors.toList());
    }

    public static List<LikePharmacologyAttr> getPharmacologyAttrs() {
        return Arrays.stream(LikePharmacologyAttr.values()).collect(Collectors.toList());
    }

    public static List<LikeCompanyNameAttr> getCompanyNameAttrs() {
        return Arrays.stream(LikeCompanyNameAttr.values()).collect(Collectors.toList());
    }
}
