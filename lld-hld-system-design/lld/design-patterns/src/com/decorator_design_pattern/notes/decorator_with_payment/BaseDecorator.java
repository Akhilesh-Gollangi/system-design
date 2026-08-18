package com.decorator_design_pattern.notes.decorator_with_payment;

public abstract class BaseDecorator implements IPayment {

    public IPayment ip;

    public BaseDecorator(IPayment ip) {
        this.ip = ip;
    }
}
