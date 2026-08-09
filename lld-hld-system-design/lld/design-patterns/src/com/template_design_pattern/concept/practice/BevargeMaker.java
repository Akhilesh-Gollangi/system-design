package com.template_design_pattern.concept.practice;

public abstract class BevargeMaker {

    public void boilWater() {
        System.out.println("Boiling of water");
    }

    // each can their own
    public abstract void brew();

    public void pourInCup() {
        System.out.println("Pour in a CUP");
    }

    // each can their own
    public abstract void condiment();


    public void makeBeverage() {
        boilWater();
        brew();
        pourInCup();
        condiment();
    }


}
