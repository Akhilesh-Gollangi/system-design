package com.practice.engine.state;

import com.practice.common.Direction;
import com.practice.engine.SnakeGame;
import com.practice.engine.exception.InvalidGameStateException;

public class GameOverState implements IGameState {

    private static GameOverState instance = new GameOverState();

    private GameOverState() {

    }

    public static GameOverState getInstance() {
        return instance;
    }

    @Override
    public void move(SnakeGame game, Direction direction) {
        throw new InvalidGameStateException("Game is over, cannot move");
    }

    @Override
    public void pause(SnakeGame game) {
        throw new InvalidGameStateException("Game is over, cannot pause");
    }

    @Override
    public void resume(SnakeGame game) {
        throw new InvalidGameStateException("Game is over, cannot resume");

    }
}
