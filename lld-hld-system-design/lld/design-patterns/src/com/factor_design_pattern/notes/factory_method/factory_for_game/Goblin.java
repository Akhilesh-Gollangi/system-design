package com.factor_design_pattern.notes.factory_method.factory_for_game;

public class Goblin  implements IEnemy {

    @Override
    public void attack() {
        System.out.println("Goblin swings his forrest dagger");
    }
}
