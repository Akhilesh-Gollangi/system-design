package com.vending_machine.practice.additionalrequirement.payment;

import com.vending_machine.practice.additionalrequirement.payment.exception.InValidPaymentException;

public class CardPayment implements IPaymentStrategy {

    private static final double MINIMUM_AMOUNT = 5.00;

    @Override
    public double process(double amount) {
        if(amount<MINIMUM_AMOUNT) {
            throw new InValidPaymentException("Amount Insufficent to process the payment");
        }
        return amount;
    }
}
