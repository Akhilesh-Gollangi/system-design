package com.practice.engine;

import com.practice.engine.state.IGameState;

public class SnakeGame {

    private IGameState state;

    public IGameState getState() {
        return state;
    }

    public void setState(IGameState state) {
        this.state = state;
    }

    public void performMove() {

    }


}
