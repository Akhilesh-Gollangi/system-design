package com.template_design_pattern.usecase.notes;

public class UPIPaymentProcessor extends PaymentProcessor {

    @Override
    public IPayment createPayment() {
        return new UPIPayment();
    }
}
