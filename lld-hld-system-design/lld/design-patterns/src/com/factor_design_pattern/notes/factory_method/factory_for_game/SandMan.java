package com.factor_design_pattern.notes.factory_method.factory_for_game;

public class SandMan  implements IEnemy{

    @Override
    public void attack() {
        System.out.println("Sand man uses sand tornado");
    }
}
