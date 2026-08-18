package com.decorator_design_pattern.practice.decorator_with_pament;

// here we need Ipayment because we have call those pay method with object
public abstract class BaseDecorator implements IPayment{
    public IPayment payment;

    public BaseDecorator(IPayment payment) {
        this.payment = payment;
    }
}
