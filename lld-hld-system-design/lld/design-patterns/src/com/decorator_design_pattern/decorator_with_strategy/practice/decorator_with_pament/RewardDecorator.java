package com.decorator_design_pattern.decorator_with_strategy.practice.decorator_with_pament;

public class RewardDecorator extends BaseDecorator {

    private IRewardStretegy reward;

    public RewardDecorator(IPayment payment, IRewardStretegy reward) {
        super(payment);
        this.reward = reward;
    }

    @Override
    public void pay() {
        payment.pay();
        reward.redeemReward();
    }
}
