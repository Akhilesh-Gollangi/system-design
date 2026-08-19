package com.decorator_design_pattern.assignment.notes.decorator_pattern;

public class CardReward implements IRewardStrategy {

    @Override
    public void getRewarded() {
        System.out.println("Getting rewarded...for Card");
    }

}
