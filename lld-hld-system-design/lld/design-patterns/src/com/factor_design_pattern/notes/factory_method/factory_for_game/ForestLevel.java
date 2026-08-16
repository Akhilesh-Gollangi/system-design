package com.factor_design_pattern.notes.factory_method.factory_for_game;

public class ForestLevel extends Level {

    @Override
    IEnemy createEnemy() {
        return new Goblin();
    }
}
