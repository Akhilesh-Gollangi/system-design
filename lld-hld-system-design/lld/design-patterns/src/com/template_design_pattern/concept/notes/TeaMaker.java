package com.template_design_pattern.concept.notes;

public class TeaMaker extends BeverageMaker {

    @Override
    public void brew() {
        System.out.println("tea");
    }

    @Override
    public void addCondiments() {
        System.out.println("adding lemon to my tea");
    }
}
