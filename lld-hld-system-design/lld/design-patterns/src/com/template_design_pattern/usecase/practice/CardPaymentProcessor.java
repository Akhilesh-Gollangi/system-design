package com.template_design_pattern.usecase.practice;

public class CardPaymentProcessor extends PaymentProcessor {

    @Override
    public IPayment createPayment() {
        return new CardPayment();
    }
}
