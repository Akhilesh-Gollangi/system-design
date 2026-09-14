package com.practice.engine;

import com.practice.board.Board;
import com.practice.common.Point;
import com.practice.food.IFoodSpawnStrategy;

import java.util.Random;

public class WrapAroundSnakeGame extends SnakeGame {
    protected WrapAroundSnakeGame(Board board, Point startPosition, IFoodSpawnStrategy foodSpawnStrategy, Random random) {
        super(board, startPosition, foodSpawnStrategy, random);
    }

    @Override
    protected Point handleBoundary(Point rawHead) {
        int wrappedRow = Math.floorMod(rawHead.getRow(), getBoard().getHeight());
        int wrappedCol = Math.floorMod(rawHead.getCol(), getBoard().getWidth());
        return new Point(wrappedRow, wrappedCol);
    }
}
