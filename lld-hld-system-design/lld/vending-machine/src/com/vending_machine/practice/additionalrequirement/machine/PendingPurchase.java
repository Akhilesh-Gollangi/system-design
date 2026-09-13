package com.vending_machine.practice.additionalrequirement.machine;

import com.vending_machine.practice.additionalrequirement.common.PaymentMethod;
import com.vending_machine.practice.additionalrequirement.trasaction.Transaction;

//Product is 510rs if user has to pay it in cash then he has to 500 and then 10
// there are multiple steps in the payment
// so deal with such thing we need this class

// In this when user added amount which is greater than or equal to product
// then we call complete function which will return the Trasaction and it will stored in trasaction manager

public class PendingPurchase {

    // we make it final because user already selected then slot then make payment
    private final Slot slot;

    private double amountReceived;

    public PendingPurchase(Slot slot) {
        this.slot = slot;
    }

    public void addAmountReceived(double amount) {
        this.amountReceived += amount;
    }

    public Slot getSlot() {
        return slot;
    }

    public double getAmountReceived() {
        return amountReceived;
    }

    public double amountToPay() {
        double amount = 0;
        if(slot.getPrice()>=amountReceived) {
            amount =  slot.getPrice() - amountReceived;
        }
        return amount;
    }

    public Transaction completeTransaction(PaymentMethod paymentMethod, double amountReceived,
                                           double changeGiven, long timestamp) {
        return new Transaction(slot.getSlotId(), slot.getProductName(), slot.getPrice(),
                paymentMethod, amountReceived, changeGiven, timestamp);
    }



}
