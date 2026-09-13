package com.practice.engine.state;

import com.practice.common.Direction;
import com.practice.engine.SnakeGame;
import com.practice.engine.exception.InvalidGameStateException;

public class PausedState implements IGameState {

    private static PausedState instance = new PausedState();

    private PausedState() {

    }

    public static PausedState getInstance() {
        return instance;
    }

    @Override
    public void move(SnakeGame game, Direction direction) {
        throw new InvalidGameStateException("Game is paused, cannot move");
    }

    @Override
    public void pause(SnakeGame game) {
        throw new InvalidGameStateException("Game is already in paused");
    }

    @Override
    public void resume(SnakeGame game) {
        game.setState(RunningState.getInstance());
    }
}
