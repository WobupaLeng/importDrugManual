package com.electric.manual.system.entity;

import lombok.Data;

@Data
public class DrugName {
    private String name;        //药品名称
    private String commonName;  //通用名称
    private String usedName;    //曾用名
    private String businessName;//商品名
    private String engName;     //英文名
    private String chName;      //汉语拼音
}
