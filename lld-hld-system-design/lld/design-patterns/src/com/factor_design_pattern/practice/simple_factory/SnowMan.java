package com.factor_design_pattern.practice.simple_factory;

public class SnowMan implements IEnemy {
    @Override
    public void attack() {
        System.out.println("SnowMan attacks with icy blasts!");
    }
}