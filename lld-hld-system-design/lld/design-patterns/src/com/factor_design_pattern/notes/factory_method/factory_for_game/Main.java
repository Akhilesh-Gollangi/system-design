package com.factor_design_pattern.notes.factory_method.factory_for_game;

public class Main {
    public static void main(String[] args) {
        Level forest = new SnowLevel();
        forest.startLevel();
    }
}
