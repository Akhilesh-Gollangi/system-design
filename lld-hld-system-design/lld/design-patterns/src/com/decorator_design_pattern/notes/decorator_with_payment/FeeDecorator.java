package com.decorator_design_pattern.notes.decorator_with_payment;

public class FeeDecorator extends BaseDecorator{


    public FeeDecorator(IPayment ip) {
        super(ip);
    }

    @Override
    public void pay() {
        System.out.println("collecting fees");
        ip.pay();
    }
}
