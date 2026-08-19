package com.decorator_design_pattern.decorator_with_strategy.notes.decorator_pattern;

public class Main {
    public static void main(String[] args) {
        IPayment p1  = new UPIPayment();
        p1.pay();

        IPayment cardWithFee  = new FeeDecorator(new CardPayment(), new CardFee());
        cardWithFee.pay();

        IPayment UPIWithFee  = new FeeDecorator(new UPIPayment(), new UPIFee());
        UPIWithFee.pay();


        IPayment cardWithReward  = new RewardDecorator(new CardPayment(), new CardReward());
        cardWithReward.pay();

        IPayment UPIWithReward  = new RewardDecorator(new UPIPayment(), new UPIReward());
        UPIWithReward.pay();

        IPayment upiWithRewardAndThenFees = new FeeDecorator(new RewardDecorator(new UPIPayment(), new UPIReward()),new CardFee()); // both case
        upiWithRewardAndThenFees.pay();

        IPayment cardWithFeeAndThenReward = new RewardDecorator(new FeeDecorator(new CardPayment(), new CardFee()), new CardReward());
        cardWithFeeAndThenReward.pay();
    }
}
