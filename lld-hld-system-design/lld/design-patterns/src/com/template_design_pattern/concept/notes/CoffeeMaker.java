package com.template_design_pattern.concept.notes;

public class CoffeeMaker extends BeverageMaker {
    @Override
    public void brew() {
        System.out.println("Coffee");
    }

    @Override
    public void addCondiments() {
        System.out.println("adding sugar to my coffee");
    }
}
