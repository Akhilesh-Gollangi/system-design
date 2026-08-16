package com.factor_design_pattern.practice.factory_method.factory_of_levels;

public abstract class Level {

    public abstract IEnemy createEnemy();

    public void start() {
        IEnemy enemy = createEnemy();
        enemy.attack();
    }

}
