package com.factor_design_pattern.practice.simple_factory;

public class Goblin implements IEnemy {
    @Override
    public void attack() {
        System.out.println("Goblin attacks with a club!");
    }
}