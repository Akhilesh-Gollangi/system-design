package com.factor_design_pattern.concept.factory_method.factory_for_game;

public class SnowMan implements IEnemy {


    @Override
    public void attack() {
        System.out.println("Snow man uses hail storm");
    }
}
