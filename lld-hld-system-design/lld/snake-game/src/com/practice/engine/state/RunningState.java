package com.practice.engine.state;

import com.practice.common.Direction;
import com.practice.engine.SnakeGame;
import com.practice.engine.exception.InvalidGameStateException;

public class RunningState implements IGameState {

    private static RunningState instance = new RunningState();

    private RunningState() {

    }

    public static RunningState getInstance() {
        return instance;
    }

    @Override
    public void move(SnakeGame game, Direction direction) {
        game.performMove();
    }

    @Override
    public void pause(SnakeGame game) {
        game.setState(PausedState.getInstance());
    }

    @Override
    public void resume(SnakeGame game) {
        System.out.println("Game is already in running state");
    }
}
