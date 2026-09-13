package com.practice.food;

import com.practice.common.Point;

public class NormalFoodItem extends FoodItem {

    private static final int NORMAL_POINT = 1;

    public NormalFoodItem(Point position) {
        super(NORMAL_POINT, position);
    }
}
