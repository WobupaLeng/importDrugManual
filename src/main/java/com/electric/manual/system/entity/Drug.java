package com.electric.manual.system.entity;

public class Drug {
    private DrugName drugName;		    //药品名称
    private String source;		        //来源
    private String imagesUrl;		    //图片
    private Composition composition;	//成分
    private String injections;		    //注射剂辅料
    private String nature;              //性状
    private String indication;		    //适应症
    private String pharmacology	;	    //药理药毒
    private String pharmacokinetics;    //药代动力学
    private String dosage;		        //用法用量
    private String specification;	    //规格
    private String roleCategory;	    //作用类别
    private String adverseReactions;    //不良反应
    private String taboo;		        //禁忌
    private String precautions; 	    //注意事项
    private String pregnantWoman;	    //孕妇及哺乳期妇女用药
    private String child;		        //儿童用药
    private String elderly;		        //老年患者用药
    private String interaction;		    //药物相互作用
    private String drugOverdose;	    //药物过量
    private String store;		        //贮藏
    private String pack;		        //包装
    private String expirationDate;	    //有效期
    private String implementationStandards;//执行标准
    private String ratifyNumber;		//批准文号
    private String company;		        //生产企业
    private String address;		        //生产地址

    public DrugName getDrugName() {
        return drugName;
    }

    public void setDrugName(DrugName drugName) {
        this.drugName = drugName;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getImagesUrl() {
        return imagesUrl;
    }

    public void setImagesUrl(String imagesUrl) {
        this.imagesUrl = imagesUrl;
    }

    public Composition getComposition() {
        return composition;
    }

    public void setComposition(Composition composition) {
        this.composition = composition;
    }

    public String getInjections() {
        return injections;
    }

    public void setInjections(String injections) {
        this.injections = injections;
    }

    public String getNature() {
        return nature;
    }

    public void setNature(String nature) {
        this.nature = nature;
    }

    public String getIndication() {
        return indication;
    }

    public void setIndication(String indication) {
        this.indication = indication;
    }

    public String getPharmacology() {
        return pharmacology;
    }

    public void setPharmacology(String pharmacology) {
        this.pharmacology = pharmacology;
    }

    public String getPharmacokinetics() {
        return pharmacokinetics;
    }

    public void setPharmacokinetics(String pharmacokinetics) {
        this.pharmacokinetics = pharmacokinetics;
    }

    public String getDosage() {
        return dosage;
    }

    public void setDosage(String dosage) {
        this.dosage = dosage;
    }

    public String getSpecification() {
        return specification;
    }

    public void setSpecification(String specification) {
        this.specification = specification;
    }

    public String getRoleCategory() {
        return roleCategory;
    }

    public void setRoleCategory(String roleCategory) {
        this.roleCategory = roleCategory;
    }

    public String getAdverseReactions() {
        return adverseReactions;
    }

    public void setAdverseReactions(String adverseReactions) {
        this.adverseReactions = adverseReactions;
    }

    public String getTaboo() {
        return taboo;
    }

    public void setTaboo(String taboo) {
        this.taboo = taboo;
    }

    public String getPrecautions() {
        return precautions;
    }

    public void setPrecautions(String precautions) {
        this.precautions = precautions;
    }

    public String getPregnantWoman() {
        return pregnantWoman;
    }

    public void setPregnantWoman(String pregnantWoman) {
        this.pregnantWoman = pregnantWoman;
    }

    public String getChild() {
        return child;
    }

    public void setChild(String child) {
        this.child = child;
    }

    public String getElderly() {
        return elderly;
    }

    public void setElderly(String elderly) {
        this.elderly = elderly;
    }

    public String getInteraction() {
        return interaction;
    }

    public void setInteraction(String interaction) {
        this.interaction = interaction;
    }

    public String getDrugOverdose() {
        return drugOverdose;
    }

    public void setDrugOverdose(String drugOverdose) {
        this.drugOverdose = drugOverdose;
    }

    public String getStore() {
        return store;
    }

    public void setStore(String store) {
        this.store = store;
    }

    public String getPack() {
        return pack;
    }

    public void setPack(String pack) {
        this.pack = pack;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getImplementationStandards() {
        return implementationStandards;
    }

    public void setImplementationStandards(String implementationStandards) {
        this.implementationStandards = implementationStandards;
    }

    public String getRatifyNumber() {
        return ratifyNumber;
    }

    public void setRatifyNumber(String ratifyNumber) {
        this.ratifyNumber = ratifyNumber;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Drug{" +
                "drugName=" + drugName +
                ", source='" + source + '\'' +
                ", imagesUrl='" + imagesUrl + '\'' +
                ", composition=" + composition +
                ", injections='" + injections + '\'' +
                ", nature='" + nature + '\'' +
                ", indication='" + indication + '\'' +
                ", pharmacology='" + pharmacology + '\'' +
                ", pharmacokinetics='" + pharmacokinetics + '\'' +
                ", dosage='" + dosage + '\'' +
                ", specification='" + specification + '\'' +
                ", roleCategory='" + roleCategory + '\'' +
                ", adverseReactions='" + adverseReactions + '\'' +
                ", taboo='" + taboo + '\'' +
                ", precautions='" + precautions + '\'' +
                ", pregnantWoman='" + pregnantWoman + '\'' +
                ", child='" + child + '\'' +
                ", elderly='" + elderly + '\'' +
                ", interaction='" + interaction + '\'' +
                ", drugOverdose='" + drugOverdose + '\'' +
                ", store='" + store + '\'' +
                ", pack='" + pack + '\'' +
                ", expirationDate='" + expirationDate + '\'' +
                ", implementationStandards='" + implementationStandards + '\'' +
                ", ratifyNumber='" + ratifyNumber + '\'' +
                ", company='" + company + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
