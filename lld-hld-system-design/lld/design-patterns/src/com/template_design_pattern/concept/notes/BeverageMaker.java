package com.template_design_pattern.concept.notes;

public abstract class BeverageMaker {

    // boil water method
    public void boilWater() {
        System.out.println("Boiling water");
    }

    // brew method
    public abstract void brew();

    // pour in a cup
    public void PourInaCup() {
        System.out.println("Pouring in a cup");
    }

    // add condiments
    public abstract void addCondiments();

    public void makeBeverage() {
        boilWater();
        brew();
        PourInaCup();
        addCondiments();
    }

}
