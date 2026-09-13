package com.practice.food;

public class BonusAfterNTimesStrategy implements IFoodSpawnStrategy {

    private int n;

    private int count;

    private final NormalFoodCreator normalFoodCreator = new NormalFoodCreator();

    private final BonusFoodCreator bonusFoodCreator = new BonusFoodCreator();

    public BonusAfterNTimesStrategy(int n) {
        this.n = n;
    }


    @Override
    public FoodCreator nextFoodItem() {
        count++;
        return count % n == 0 ? bonusFoodCreator : normalFoodCreator;
    }
}
