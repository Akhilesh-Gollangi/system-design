package com.decorator_design_pattern.notes.decorator_with_payment;

public class RewardDecorator extends BaseDecorator{

    public RewardDecorator(IPayment ip) {
        super(ip);
    }

    @Override
    public void pay() {
        ip.pay();
        System.out.println("Reward initiated");
    }
}
