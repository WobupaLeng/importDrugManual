package com.electric.manual.common.constant;

import com.electric.manual.system.entity.Company;
import com.electric.manual.system.entity.Composition;
import com.electric.manual.system.entity.DrugManual;
import com.electric.manual.system.entity.DrugName;
import lombok.SneakyThrows;

public enum DrugManualAttr implements SingleIntEnum {
    //drugName 药品名称
    NAME(1, "药品名称"),
    COMMON_NAME(2, "通用名称"),
    USED_NAME(3, "曾用名"),
    BUSINESS_NAME(4, "商品名"),
    ENG_NAME(5, "英文名"),
    CH_NAME(6, "汉语拼音"),

    MANUAL_SOURCE(7, "说明书来源"),
    IMAGES_URL(8, "包装图"),

    //composition 成分
    CHEMICAL_NAME(9, "主要成分及其化学名称"),
    INGREDIENT(10, "成份"),
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

    DrugManualAttr(int value, String name) {
        this.value = value;
        this.name = name;
    }

    @SneakyThrows
    public static void setEntity(DrugManualAttr attr, String attrStr, DrugManual drugManual, DrugName drugName, Composition composition, Company company) {
        switch (attr) {
            case NAME:
                //drugName.setName(attrStr);
                break;
            case COMMON_NAME:
                drugName.setCommonName(attrStr);
                break;
            case USED_NAME:
                drugName.setUsedName(attrStr);
                break;
            case BUSINESS_NAME:
                drugName.setBusinessName(attrStr);
                break;
            case ENG_NAME:
                drugName.setEngName(attrStr);
                break;
            case CH_NAME:
                drugName.setChName(attrStr);
                break;
            case MANUAL_SOURCE:
                drugManual.setManualSource(attrStr);
                break;
            case IMAGES_URL:
                drugManual.setImagesUrl(attrStr);
                break;
            case CHEMICAL_NAME:
                composition.setChemicalName(attrStr);
                break;
            case INGREDIENT:
                composition.setIngredient(attrStr);
                break;
            case MOLECULAR_FORMULA:
                composition.setMolecularFormula(attrStr);
                break;
            case MOLECULAR_WEIGHT:
                composition.setMolecularWeight(attrStr);
                break;
            case CHEMICAL_STRUCTURE:
                composition.setChemicalStructure(attrStr);
                break;
            case INJECTIONS:
                drugManual.setInjections(attrStr);
                break;
            case NATURE:
                drugManual.setNature(attrStr);
                break;
            case INDICATION:
                drugManual.setIndication(attrStr);
                break;
            case PHARMACOLOGY:
                drugManual.setPharmacology(attrStr);
                break;
            case PHARMACOKINETICS:
                drugManual.setPharmacokinetics(attrStr);
                break;
            case DOSAGE:
                drugManual.setDosage(attrStr);
                break;
            case SPECIFICATION:
                drugManual.setSpecification(attrStr);
                break;
            case ROLE_CATEGORY:
                drugManual.setRoleCategory(attrStr);
                break;
            case ADVERSE_REACTIONS:
                drugManual.setAdverseReactions(attrStr);
                break;
            case TABOO:
                drugManual.setTaboo(attrStr);
                break;
            case PRECAUTIONS:
                drugManual.setPrecautions(attrStr);
                break;
            case PREGNANT_WOMAN:
                drugManual.setPregnantWoman(attrStr);
                break;
            case CHILD:
                drugManual.setChild(attrStr);
                break;
            case ELDERLY:
                drugManual.setElderly(attrStr);
                break;
            case INTERACTION:
                drugManual.setInteraction(attrStr);
                break;
            case DRUG_OVERDOSE:
                drugManual.setDrugOverdose(attrStr);
                break;
            case STORE:
                drugManual.setStore(attrStr);
                break;
            case PACK:
                drugManual.setPack(attrStr);
                break;
            case EXPIRATION_DATE:
                drugManual.setExpirationDate(attrStr);
                break;
            case IMPLEMENTATION_STANDARDS:
                drugManual.setImplementationStandards(attrStr);
                break;
            case RATIFY_NUMBER:
                drugManual.setRatifyNumber(attrStr);
                break;
            case COMPANY_NAME:
                company.setCompanyName(attrStr);
                break;
            case COMPANY_ADDRESS:
                company.setCompanyAddress(attrStr);
                break;
            case COMPANY_POSTCODE:
                company.setCompanyPostcode(attrStr);
                break;
            case COMPANY_MOBILE:
                company.setCompanyMobile(attrStr);
                break;
            case COMPANY_FAX:
                company.setCompanyFax(attrStr);
                break;
            case COMPANY_URL:
                company.setCompanyUrl(attrStr);
                break;
            default:
                throw new Exception("error");
        }
    }

    @Override
    public int getValue() {
        return value;
    }

    @Override
    public String getName() {
        return name;
    }
}
