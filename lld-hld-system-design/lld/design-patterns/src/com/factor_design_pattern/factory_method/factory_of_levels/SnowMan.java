package com.factor_design_pattern.factory_method.factory_of_levels;

public class SnowMan implements IEnemy {
    @Override
    public void attack() {
        System.out.println("SnowMan attacks with icy blasts!");
    }
}