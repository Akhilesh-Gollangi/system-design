package com.decorator_design_pattern.assignment.practice.decorator_with_pament;

// Here we have Ipayment Interface with abstract pay method
// this is IPayement is implemeneted by card and upi and each have overriden pay and have their own logic


// now our aim to add 3 new functionalities to these like fee, Reward, bothfeeandreward
// where the funcationality is different for all the exisitng classes
// we should not make any changes in existing classes
// In general how we do : we create subclasses for each functionality having parent as card or UPI
// But for each functionality we have 1 so 3 functionalities 3 classes
// we have these 3 subclasses for each payment type of 3*2 = 6
// suppose we have 5 classes and 6 functionalities then it 5*6=30 classes
// which is class explostion

//previously  where the funcationality is same for all the exisitng classes but now it is different logic for
//each funcationality
public class Main {
    public static void main(String[] args) {
        // how do we acheive it
        // Here alogorithm of fee and reward vary from UPI to card
        // so changing behaviour so we can use strategy pattern there

        IPayment upiFee = new FeeDecorator(new UPIPayment(), new UPIFee());
        upiFee.pay();

        IPayment upiReward = new RewardDecorator(new UPIPayment(), new UPIReward());
        upiReward.pay();

        //both

        IPayment upiFeeAndThenReward = new RewardDecorator(new FeeDecorator(new CardPayment(), new CardFee()), new CardReward());
        upiFeeAndThenReward.pay();


        // before this i code like UPIFeeDecortaot and CardFeeDecorator like that
        // the problem with that it

        /*
        3. But here's the REALLY important part

The problem isn't simply:

"48 classes is a lot."

The deeper problem is that you've coupled two independent dimensions.

You have:

Payment Type
      ×
Behavior/Algorithm

Every time you add a payment type, you potentially have to create a class for every functionality.

Every time you add a functionality, you potentially have to create a class for every payment type.

That's combinatorial growth.

4. Strategy breaks that relationship

Suppose Fee has these algorithms:

Percentage Fee
Fixed Fee
No Fee
Dynamic Fee

Instead of:

CardPercentageFeeDecorator
CardFixedFeeDecorator
CardNoFeeDecorator


UPIPercentageFeeDecorator
UPIFixedFeeDecorator
UPINoFeeDecorator


WalletPercentageFeeDecorator
WalletFixedFeeDecorator
WalletNoFeeDecorator

you separate the dimensions.

Payment
 ├── Card
 ├── UPI
 └── Wallet


FeeStrategy
 ├── PercentageFee
 ├── FixedFee
 ├── NoFee
 └── DynamicFee

Now you have:

3 payment classes + 4 fee strategies

instead of potentially:

3 × 4 = 12 combination classes
         */


    }
}
