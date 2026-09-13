package com.practice.observer;

public class ConsoleGameObserver implements IGameObserver{

    @Override
    public void onScoreChange(int score) {
        System.out.println("Score : " + score);

    }

    @Override
    public void onGameOver(int finalScore) {
        System.out.println("Final score : "+ finalScore);
    }
}
