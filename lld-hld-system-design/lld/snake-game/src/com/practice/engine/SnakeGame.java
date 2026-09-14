package com.practice.engine;

import com.practice.board.Board;
import com.practice.common.Direction;
import com.practice.common.Point;
import com.practice.engine.state.GameOverState;
import com.practice.engine.state.IGameState;
import com.practice.engine.state.RunningState;
import com.practice.food.FoodItem;
import com.practice.food.IFoodSpawnStrategy;
import com.practice.observer.IGameObserver;

import java.util.*;

public abstract class SnakeGame {

    private final Board board;

    private final IFoodSpawnStrategy foodSpawnStrategy;

    private final Random random;

    private List<IGameObserver> observers = new ArrayList<>();

    private Deque<Point> body = new ArrayDeque<>();

    private Set<Point> occupied = new HashSet<>();

    private IGameState state = RunningState.getInstance();

    private FoodItem currentFood;

    private int score;

    protected SnakeGame(Board board, Point startPosition, IFoodSpawnStrategy foodSpawnStrategy, Random random) {
        this.board = board;
        this.foodSpawnStrategy = foodSpawnStrategy;
        this.random = random;
        body.add(startPosition);
        occupied.add(startPosition);
        this.currentFood = spawnFood();
    }

    public void addObserver(IGameObserver observer) {
        observers.add(observer);
    }

    public IGameState getState() {
        return state;
    }

    public void setState(IGameState state) {
        this.state = state;
    }

    public void move(Direction direction) {
        state.move(this, direction);
    }

    public void pause() {
        state.pause(this);
    }

    public void resume() {
        state.resume(this);
    }


    public void performMove(Direction direction) {
        Point currentHead = body.peekFirst();
        Point rawHead = new Point(currentHead.getRow() + direction.getDeltaRow(),
                currentHead.getCol() + direction.getDeltaCol());
        Point newHead = handleBoundary(rawHead);
        if (newHead == null) {
            endGame();
            return;
        }

        Point tail = body.peekLast();
        boolean eatsFood = newHead.equals(currentFood.getPosition());
        boolean bitesItSelf = occupied.contains(newHead) && !(newHead.equals(tail));

        if (bitesItSelf) {
            endGame();
            return;
        }

        if (eatsFood) {
            body.addFirst(newHead);
            occupied.add(newHead);
            score += currentFood.getPoints();
            currentFood = spawnFood();
            notifyScoreChanged();
        } else {
            body.pollLast();
            occupied.remove(tail);
            body.addFirst(newHead);
            occupied.add(newHead);
        }
    }

    protected abstract Point handleBoundary(Point rawHead);

    private FoodItem spawnFood() {
        Point position;
        do {
            position = new Point(random.nextInt(board.getHeight()), random.nextInt(board.getWidth()));
        } while (occupied.contains(position));
        return foodSpawnStrategy.nextFoodItem().spawnAt(position);
    }

    private void endGame() {
        setState(GameOverState.getInstance());
        notifyGameOver();
    }

    private void notifyScoreChanged() {
        for (IGameObserver observer : observers) {
            observer.onScoreChange(score);
        }
    }

    private void notifyGameOver() {
        for (IGameObserver observer : observers) {
            observer.onGameOver(score);
        }
    }

    public boolean isOver() {
        return state == GameOverState.getInstance();
    }

    public Board getBoard() {
        return board;
    }

    public Point getFoodPosition() {
        return currentFood.getPosition();
    }

    public int getLength() {
        return body.size();
    }

    public Point getHead() {
        return body.peekFirst();
    }

    public int getScore() {
        return score;
    }
}
