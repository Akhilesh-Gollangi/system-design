package com.template_design_pattern.usecase.notes;

public class CardPaymentProcessor extends PaymentProcessor {

    @Override
    public IPayment createPayment() {
        return new  CardPayment();
    }
}
