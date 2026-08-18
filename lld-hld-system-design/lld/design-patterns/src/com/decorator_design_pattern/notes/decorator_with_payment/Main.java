package com.decorator_design_pattern.notes.decorator_with_payment;

public class Main {

    public static void main(String[] args) {
        IPayment p1  = new UPIPayment();
        p1.pay();

        IPayment cardWithFee  = new FeeDecorator(new CardPayment());
        cardWithFee.pay();

        IPayment UPIWithFee  = new FeeDecorator(new UPIPayment());
        UPIWithFee.pay();


        IPayment cardWithReward  = new RewardDecorator(new CardPayment());
        cardWithReward.pay();

        IPayment UPIWithReward  = new RewardDecorator(new UPIPayment());
        UPIWithReward.pay();

        IPayment upiWithRewardAndThenFees = new FeeDecorator(new RewardDecorator(new UPIPayment())); // both case
        upiWithRewardAndThenFees.pay();

        IPayment cardWithFeeAndThenReward = new RewardDecorator(new FeeDecorator(new CardPayment()));
        cardWithFeeAndThenReward.pay();
    }
}
