package com.factor_design_pattern.notes.factory_method.factory_of_levels;

public class Level1 extends Level{
    @Override
    public IEnemy createEnemy() {
        return new Goblin();
    }
}
