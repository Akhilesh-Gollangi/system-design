package com.factor_design_pattern.notes.simple_factory;

public class Level {

    public void start(String level) {
        SimpleFactory simpleFactory = new SimpleFactory();
        IEnemy enemy = simpleFactory.getEnemy(level);
//        IEnemy enemy = simpleFactory.getEnemyS(level);
        enemy.attack();
    }
}
