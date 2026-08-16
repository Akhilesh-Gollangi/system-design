package com.factor_design_pattern.notes.abstract_factory_design_pattern;

public class VictorianChair implements Chair {
    @Override
    public void sitOn() {
        System.out.println("Sitting on an ornately carved Victorian chair.");
    }
}
