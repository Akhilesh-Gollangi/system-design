package com.practice.registry;

public class HighScoreRegistry {

    private static final HighScoreRegistry instance = new HighScoreRegistry();

    private int highScore;

    private HighScoreRegistry() {

    }

    public static HighScoreRegistry getInstance() {
        return instance;
    }

    public void readScore(int score) {
        if (score > highScore) {
            highScore = score;
        }
    }

    public int getHighScore() {
        return highScore;
    }
}
