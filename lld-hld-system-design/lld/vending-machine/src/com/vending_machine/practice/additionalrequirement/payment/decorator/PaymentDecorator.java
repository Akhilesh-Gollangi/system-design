package com.vending_machine.practice.additionalrequirement.payment.decorator;

import com.vending_machine.practice.additionalrequirement.payment.IPaymentStrategy;

// to support new functionality over existing code we need decorator
// here we are supporting reward feature for payments
public abstract class PaymentDecorator implements IPaymentStrategy {

    protected final IPaymentStrategy wrappedPayment;

    public PaymentDecorator(IPaymentStrategy wrappedPayment) {
        this.wrappedPayment = wrappedPayment;
    }
}
