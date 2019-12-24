package com.electric.instructions.system.entity;

public class DrugName {
    private String name;        //药品名称
    private String commonName;  //通用名称
    private String usedName;    //曾用名
    private String businessName;//商品名
    private String engName;     //英文名
    private String chName;      //汉语拼音

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCommonName() {
        return commonName;
    }

    public void setCommonName(String commonName) {
        this.commonName = commonName;
    }

    public String getUsedName() {
        return usedName;
    }

    public void setUsedName(String usedName) {
        this.usedName = usedName;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public String getEngName() {
        return engName;
    }

    public void setEngName(String engName) {
        this.engName = engName;
    }

    public String getChName() {
        return chName;
    }

    public void setChName(String chName) {
        this.chName = chName;
    }

    @Override
    public String toString() {
        return "DrugName{" +
                "name='" + name + '\'' +
                ", commonName='" + commonName + '\'' +
                ", usedName='" + usedName + '\'' +
                ", businessName='" + businessName + '\'' +
                ", engName='" + engName + '\'' +
                ", chName='" + chName + '\'' +
                '}';
    }
}
