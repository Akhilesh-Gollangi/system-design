package com.decorator_design_pattern.practice.decorator_with_pament;

// Here we have Ipayment Interface with abstract pay method
// this is IPayement is implemeneted by card and upi and each have overriden pay and have their own logic


// now our aim to add 3 new functionalities to these like fee, Reward, bothfeeandreward
// where the funcationality is same for all the exisitng classes
// we should not make any changes in existing classes
// In general how we do : we create subclasses for each functionality having parent as card or UPI
// But for each functionality we have 1 so 3 functionalities 3 classes
// we have these 3 subclasses for each payment type of 3*2 = 6
// suppose we have 5 classes and 6 functionalities then it 5*6=30 classes
// which is class explostion

// To avoid this class explosion, we have Decorator Design Pattern

// Instead creating 6 classes
// we will create 3 classes for each functionality and 1 abstract class
// Here we have BothFeeAndReward did we really need 3 classes we can acheive it by 2 classes
// We will have common class which common for all the funcationlities and funcationality classes
// excluding the both
public class Main {
    public static void main(String[] args) {
        IPayment cardWithFee = new FeeDecorator(new CardPayment());
        cardWithFee.pay();

        IPayment cardWithReward = new RewardDecorator(new CardPayment());
        cardWithReward.pay();

        IPayment UPIWithFee = new FeeDecorator(new UPIPayment());
        UPIWithFee.pay();

        IPayment UPIWithReward = new RewardDecorator(new UPIPayment());
        UPIWithReward.pay();

        // here first we will go to FeeDecorator class which RewardDecorator object and paymethod
        // FeeDecorator fee logic is executed then RewardDecorator pay method is called
        // RewardDecorator has pay method and UPI Object
        // first UPI pay method is called after completion, Reward logic is applied
        // here we achieved bothFeeAndReward functionality without adding new class
        // this is beauty of Decorator Design Pattern
        IPayment UPIwithFeeAndThenReward = new FeeDecorator(new RewardDecorator(new UPIPayment()));
        UPIwithFeeAndThenReward.pay();

        IPayment cardWithRewardAndThenFee = new RewardDecorator(new FeeDecorator(new CardPayment()));
        cardWithRewardAndThenFee.pay();





    }
}
