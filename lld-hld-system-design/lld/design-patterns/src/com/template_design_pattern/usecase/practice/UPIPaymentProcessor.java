package com.template_design_pattern.usecase.practice;

public class UPIPaymentProcessor extends PaymentProcessor{

    @Override
    public IPayment createPayment() {
        return new UPIPayment();
    }
}
