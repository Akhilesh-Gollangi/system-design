package com.practice.food;

import com.practice.common.Point;

// this is factory method
public abstract class FoodCreator {

    public abstract FoodItem createFood(Point position);

    public final FoodItem spawnAt(Point position) {
        return createFood(position);
    }
}
