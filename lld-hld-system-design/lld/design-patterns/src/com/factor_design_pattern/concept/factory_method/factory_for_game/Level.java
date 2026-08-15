package com.factor_design_pattern.concept.factory_method.factory_for_game;

public abstract class Level {

    abstract IEnemy createEnemy();


    public void startLevel(){

        IEnemy enemy = createEnemy();
        enemy.attack();
    }


}
