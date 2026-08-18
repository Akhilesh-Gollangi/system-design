package com.decorator_design_pattern.practice.decorator_with_pament;

public class FeeDecorator extends BaseDecorator {


    public FeeDecorator(IPayment payment) {
        super(payment);
    }

    @Override
    public void pay() {
        System.out.println("A processing fee has been added to this payment.");
        payment.pay();
    }
}
