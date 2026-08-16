package com.factor_design_pattern.practice.factory_method.factory_of_levels;

public class Level3 extends Level{
    @Override
    public IEnemy createEnemy() {
        return new SnowMan();
    }
}
