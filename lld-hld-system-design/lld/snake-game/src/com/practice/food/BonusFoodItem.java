package com.practice.food;

import com.practice.common.Point;

public class BonusFoodItem extends FoodItem {

    private static final int BONUS_POINT = 5;

    public BonusFoodItem(Point position) {
        super(BONUS_POINT, position);
    }
}
