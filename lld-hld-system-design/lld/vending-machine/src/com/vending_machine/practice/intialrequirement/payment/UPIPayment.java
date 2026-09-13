package com.vending_machine.practice.intialrequirement.payment;

import com.vending_machine.practice.intialrequirement.payment.exception.InValidPaymentException;

public class UPIPayment implements IPaymentStrategy {

    private static final double SERVICE_FEE = 0.10;

    @Override
    public double process(double amount) {
        if (amount < SERVICE_FEE) {
            throw new InValidPaymentException("Amount Insufficent to process the payment");
        }
        return amount - SERVICE_FEE;
    }
}
