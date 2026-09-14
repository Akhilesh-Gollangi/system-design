package com.practice.observer;

import com.practice.registry.HighScoreRegistry;

public class HighScoreObserver implements IGameObserver{
    @Override
    public void onScoreChange(int score) {
        // this is class is specifically for high score
    }

    @Override
    public void onGameOver(int finalScore) {
        HighScoreRegistry.getInstance().readScore(finalScore);
    }
}
