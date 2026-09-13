package com.vending_machine.practice.additionalrequirement.payment.decorator;

import com.vending_machine.practice.additionalrequirement.payment.IPaymentStrategy;

public class CashBackDecorator extends PaymentDecorator{

    private static final double CASH_BACK = 0.40;

    public CashBackDecorator(IPaymentStrategy paymentStrategy) {
        super(paymentStrategy);
    }

    @Override
    public double process(double amount) {
        return wrappedPayment.process(amount) + CASH_BACK;
    }

    // Now I want to support this for UPI
    // so i have to make changes in PaymentMethod and factory
    // UPI_CASHBACK method
}
