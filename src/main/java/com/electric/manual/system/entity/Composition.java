package com.electric.manual.system.entity;

import lombok.Data;

@Data
public class Composition {
    private String chemicalName;        //主要成分及其化学名称
    private String ingredient;          //成分
    private String molecularFormula;    //分子式
    private String molecularWeight;     //分子量
    private String chemicalStructure;   //化学结构式
}
