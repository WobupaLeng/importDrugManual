package com.electric.manual.common.constant;

public enum DrugManualAttrType implements SingleIntEnum {

    //drugName 药品名称
    NAME(1, "药品名称"),
    COMMON_NAME(2, "通用名称"),
    USED_NAME(3, "曾用名"),
    BUSINESS_NAME(4, "商品名"),
    ENG_NAME(5, "英文名"),
    CH_NAME(6, "汉语拼音"),

    MANUAL_SOURCE(7, "说明书来源"),
    IMAGES_URL(8, "图片"),

    //composition 成分
    CHEMICAL_NAME(9, "主要成分及其化学名称"),
    INGREDIENT(10, "成分"),
    MOLECULAR_FORMULA(11, "分子式"),
    MOLECULAR_WEIGHT(12, "分子量"),
    CHEMICAL_STRUCTURE(13, "化学结构式"),

    INJECTIONS(14, "注射剂辅料"),
    NATURE(15, "性状"),
    INDICATION(16, "适应症"),
    PHARMACOLOGY(17, "药理毒理"),
    PHARMACOKINETICS(18, "药代动力学"),
    DOSAGE(19, "用法用量"),
    SPECIFICATION(20, "规格"),
    ROLE_CATEGORY(21, "作用类别"),
    ADVERSE_REACTIONS(22, "不良反应"),
    TABOO(23, "禁忌"),
    PRECAUTIONS(24, "注意事项"),
    PREGNANT_WOMAN(25, "孕妇及哺乳期妇女用药"),
    CHILD(26, "儿童用药"),
    ELDERLY(27, "老年患者用药"),
    INTERACTION(28, "药物相互作用"),
    DRUG_OVERDOSE(29, "药物过量"),
    STORE(30, "贮藏"),
    PACK(31, "包装"),
    EXPIRATION_DATE(32, "有效期"),
    IMPLEMENTATION_STANDARDS(33, "执行标准"),
    RATIFY_NUMBER(34, "批准文号"),

    //company
    COMPANY_NAME(35, "企业名称"),
    COMPANY_ADDRESS(36, "生产地址"),
    COMPANY_POSTCODE(37, "邮政编码"),
    COMPANY_MOBILE(38, "电话号码"),
    COMPANY_FAX(39, "传真号码"),
    COMPANY_URL(40, "网址");

    private final int value;
    private final String name;

    DrugManualAttrType(int value, String name) {
        this.value = value;
        this.name = name;
    }

    @Override
    public int getValue() {
        return 0;
    }

    @Override
    public String getName() {
        return null;
    }
}
