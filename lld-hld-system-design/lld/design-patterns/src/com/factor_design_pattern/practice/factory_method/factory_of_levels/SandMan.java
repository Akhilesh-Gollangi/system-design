package com.factor_design_pattern.practice.factory_method.factory_of_levels;

public class SandMan implements IEnemy {
    @Override
    public void attack() {
        System.out.println("SandMan attacks with a sandstorm!");
    }
}