package com.factor_design_pattern.factory_method.factory_of_levels;

public class Level2 extends Level{
    @Override
    public IEnemy createEnemy() {
        return new SandMan();
    }
}
