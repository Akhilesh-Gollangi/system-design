package com.factor_design_pattern.notes.factory_method.factory_for_game;

public class DesertLevel extends Level {

    @Override
    IEnemy createEnemy() {
        return new SandMan();
    }
}
