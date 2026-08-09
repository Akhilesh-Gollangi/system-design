package com.template_design_pattern.concept;

public class TeaMaker extends BevargeMaker {

    @Override
    public void brew() {
        System.out.println("Steeping the tea");
    }

    @Override
    public void condiment() {
        System.out.println("Adding Lemon");
    }
}
