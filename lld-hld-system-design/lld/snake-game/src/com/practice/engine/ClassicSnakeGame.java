package com.practice.engine;

import com.practice.board.Board;
import com.practice.common.Point;
import com.practice.food.IFoodSpawnStrategy;

import java.util.Random;

public class ClassicSnakeGame extends SnakeGame {
    public ClassicSnakeGame(Board board, Point startPosition, IFoodSpawnStrategy foodSpawnStrategy, Random random) {
        super(board, startPosition, foodSpawnStrategy, random);
    }

    @Override
    protected Point handleBoundary(Point rawHead) {
        boolean withBoundary = getBoard().isWithBoundary(rawHead.getRow(), rawHead.getCol());
        return withBoundary ? rawHead : null;
    }
}
