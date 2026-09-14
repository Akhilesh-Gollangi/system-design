package com.practice.app;

import com.practice.board.Board;
import com.practice.common.Direction;
import com.practice.common.Point;
import com.practice.engine.ClassicSnakeGame;
import com.practice.engine.SnakeGame;
import com.practice.engine.exception.InvalidGameStateException;
import com.practice.food.IFoodSpawnStrategy;
import com.practice.food.RandomFoodSpawnStrategy;
import com.practice.observer.ConsoleGameObserver;
import com.practice.observer.HighScoreObserver;

import java.lang.module.InvalidModuleDescriptorException;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        classicSnakeDemo();
    }

   public static void classicSnakeDemo() {
       Board board = new Board(5,5);
       Random random = new Random(40);
       IFoodSpawnStrategy spawnStrategy = new RandomFoodSpawnStrategy(random);
       SnakeGame snakeGame = new ClassicSnakeGame(board,new Point(3,3),spawnStrategy,random);
       snakeGame.addObserver(new ConsoleGameObserver());
       snakeGame.addObserver(new HighScoreObserver());

       runGreedyUntilGameOverOrLimit(snakeGame, 40);

       try {
           snakeGame.pause();
           snakeGame.move(Direction.UP);
       } catch (InvalidGameStateException e) {
           System.out.println("Exception "+ e.getMessage());
       }

   }

    private static void runGreedyUntilGameOverOrLimit(SnakeGame game, int maxSteps) {
        for (int i = 0; i < maxSteps && !game.isOver(); i++) {
            game.move(pickGreedyDirection(game.getHead(), game.getFoodPosition()));
        }
        if (game.isOver()) {
            System.out.println("stopped: game ended, final length: " + game.getLength());
        } else {
            System.out.println("stopped after step limit, score: " + game.getScore()
                    + ", length: " + game.getLength());
        }
    }

    private static Direction pickGreedyDirection(Point head, Point food) {
        if (food.getRow() < head.getRow()) return Direction.UP;
        if (food.getRow() > head.getRow()) return Direction.DOWN;
        if (food.getCol() < head.getCol()) return Direction.LEFT;
        return Direction.RIGHT;
    }
}
