package com.factor_design_pattern.concept.factory_method.factory_for_game;

public class SnowLevel extends Level{

    @Override
    IEnemy createEnemy() {
        return new SnowMan();
    }
}
