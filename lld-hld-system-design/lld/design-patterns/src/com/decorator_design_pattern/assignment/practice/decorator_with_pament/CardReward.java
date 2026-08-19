package com.decorator_design_pattern.assignment.practice.decorator_with_pament;

public class CardReward implements IRewardStretegy {
    @Override
    public void redeemReward() {
        System.out.println("Reward points redeemed for Card payment.");
    }
}