package com.practice.engine.state;

import com.practice.common.Direction;
import com.practice.engine.SnakeGame;

public interface IGameState {

    void move(SnakeGame game, Direction direction);

    void pause(SnakeGame game);

    void resume(SnakeGame game);


}
