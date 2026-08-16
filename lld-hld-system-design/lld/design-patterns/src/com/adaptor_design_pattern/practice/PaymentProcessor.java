package com.adaptor_design_pattern.practice;

public class PaymentProcessor {

    private IPayment payment;

    public PaymentProcessor() {

    }

    public PaymentProcessor(IPayment payment) {
        this.payment = payment;
    }

    public void setPayment(IPayment payment) {
        this.payment = payment;
    }

    public void process() {
        payment.pay();
    }
}
