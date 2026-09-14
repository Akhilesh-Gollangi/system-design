package com.practice.food;

import java.util.Random;

public class RandomFoodSpawnStrategy implements IFoodSpawnStrategy {

    private static final double PROBABILITY = 2.0;

    private final Random random;

    private final NormalFoodCreator normalFoodCreator = new NormalFoodCreator();

    private final BonusFoodCreator bonusFoodCreator = new BonusFoodCreator();

    public RandomFoodSpawnStrategy(Random random) {
        this.random = random;
    }

    @Override
    public FoodCreator nextFoodItem() {
        return random.nextDouble() < PROBABILITY ? bonusFoodCreator : normalFoodCreator;
    }
}
