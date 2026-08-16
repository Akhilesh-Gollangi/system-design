package com.factor_design_pattern.practice.factory_method.factory_of_levels;

public class Goblin implements IEnemy {
    @Override
    public void attack() {
        System.out.println("Goblin attacks with a club!");
    }
}