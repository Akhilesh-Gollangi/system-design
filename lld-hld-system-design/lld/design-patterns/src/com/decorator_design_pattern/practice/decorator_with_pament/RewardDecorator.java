package com.decorator_design_pattern.practice.decorator_with_pament;

public class RewardDecorator extends BaseDecorator{

    public RewardDecorator(IPayment payment) {
        super(payment);
    }

    @Override
    public void pay() {
        payment.pay();
        System.out.println("Reward points added for this payment.");
    }
}
