package com.vending_machine.practice.payment;

import com.vending_machine.practice.payment.exception.InValidPaymentException;

public class CashPayment implements IPaymentStrategy{

    @Override
    public double process(double amount) {
        if(amount<=0) {
            throw new InValidPaymentException("Invalid cash Entered into machine");
        }
        return amount;
    }
}
