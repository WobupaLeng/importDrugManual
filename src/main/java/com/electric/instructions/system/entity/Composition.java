package com.electric.instructions.system.entity;

public class Composition {
    private String chemicalName;        //主要成分及其化学名称
    private String ingredient;          //成分
    private String molecularFormula;    //分子式
    private String molecularWeight;     //分子量
    private String chemicalStructure;   //化学结构式

    public String getChemicalName() {
        return chemicalName;
    }

    public void setChemicalName(String chemicalName) {
        this.chemicalName = chemicalName;
    }

    public String getIngredient() {
        return ingredient;
    }

    public void setIngredient(String ingredient) {
        this.ingredient = ingredient;
    }

    public String getMolecularFormula() {
        return molecularFormula;
    }

    public void setMolecularFormula(String molecularFormula) {
        this.molecularFormula = molecularFormula;
    }

    public String getMolecularWeight() {
        return molecularWeight;
    }

    public void setMolecularWeight(String molecularWeight) {
        this.molecularWeight = molecularWeight;
    }

    public String getChemicalStructure() {
        return chemicalStructure;
    }

    public void setChemicalStructure(String chemicalStructure) {
        this.chemicalStructure = chemicalStructure;
    }

    @Override
    public String toString() {
        return "Composition{" +
                "chemicalName='" + chemicalName + '\'' +
                ", ingredient='" + ingredient + '\'' +
                ", molecularFormula='" + molecularFormula + '\'' +
                ", molecularWeight='" + molecularWeight + '\'' +
                ", chemicalStructure='" + chemicalStructure + '\'' +
                '}';
    }
}
