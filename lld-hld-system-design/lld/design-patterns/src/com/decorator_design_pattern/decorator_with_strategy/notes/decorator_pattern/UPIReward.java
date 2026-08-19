package com.decorator_design_pattern.decorator_with_strategy.notes.decorator_pattern;

public class UPIReward implements IRewardStrategy {

    @Override
    public void getRewarded() {
        System.out.println("Getting rewarded...for UPI");
    }

}
