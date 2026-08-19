package com.decorator_design_pattern.decorator_with_strategy.practice.decorator_with_pament;

public class UPIReward implements IRewardStretegy {
    @Override
    public void redeemReward() {
        System.out.println("Reward points redeemed for UPI payment.");
    }
}