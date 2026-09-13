package com.practice.observer;

public interface IGameObserver {

    void onScoreChange(int score);

    void onGameOver(int finalScore);
}
