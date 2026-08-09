package com.template_design_pattern.usecase.practice;

public class CashPaymentProcessor extends PaymentProcessor {


    @Override
    public IPayment createPayment() {
        return new CashPayment();
    }

    public boolean requiredOTPVerification() {
        return false;
    }

}
