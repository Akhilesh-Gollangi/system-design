package com.template_design_pattern.usecase.notes;

public class CashPaymentProcessor extends PaymentProcessor {

    @Override
    public IPayment createPayment() {
        return new CashPayment();
    }

    @Override
    public boolean requiresOTPVerification(){
        return false;
    }
}