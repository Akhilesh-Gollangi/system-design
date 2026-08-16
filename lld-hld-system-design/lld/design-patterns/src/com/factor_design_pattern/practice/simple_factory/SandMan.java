package com.factor_design_pattern.practice.simple_factory;

public class SandMan implements IEnemy {
    @Override
    public void attack() {
        System.out.println("SandMan attacks with a sandstorm!");
    }
}