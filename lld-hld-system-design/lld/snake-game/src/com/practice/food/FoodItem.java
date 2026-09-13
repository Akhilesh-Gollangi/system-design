package com.practice.food;

import com.practice.common.Point;

public class FoodItem {

    private final int points;

    private final Point position;

    public FoodItem(int points, Point position) {
        this.points = points;
        this.position = position;
    }

    public int getPoints() {
        return points;
    }

    public Point getPosition() {
        return position;
    }
}
