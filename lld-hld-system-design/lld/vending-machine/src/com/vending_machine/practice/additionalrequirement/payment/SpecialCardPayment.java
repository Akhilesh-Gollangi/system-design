package com.vending_machine.practice.additionalrequirement.payment;

import com.vending_machine.practice.additionalrequirement.payment.exception.InValidPaymentException;

// It is special card payment, it should not implement IPayment
// It want feature of card Payment
public class SpecialCardPayment extends CardPayment {

    private static final double SPECIAL_SURGE_FEE = 0.75;

    public double process(double amount) {
        return super.process(amount) - SPECIAL_SURGE_FEE;
    }

    // NOW how can we call this, so we need to make changes in PaymentMethod and factory
}
