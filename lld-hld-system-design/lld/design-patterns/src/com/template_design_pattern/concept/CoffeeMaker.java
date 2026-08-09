package com.template_design_pattern.concept;

public class CoffeeMaker extends BevargeMaker {

    @Override
    public void brew() {
        System.out.println("Dripping Coffee through filter");
    }

    @Override
    public void condiment() {
        System.out.println("Adding Sugar and Milk");
    }
}
