package com.practice.food;

import com.practice.common.Point;

// THis is factory method
// where child take responsibilty of creating objects
public class BonusFoodCreator extends FoodCreator {
    @Override
    public FoodItem createFood(Point position) {
        return new BonusFoodItem(position);
    }
}
