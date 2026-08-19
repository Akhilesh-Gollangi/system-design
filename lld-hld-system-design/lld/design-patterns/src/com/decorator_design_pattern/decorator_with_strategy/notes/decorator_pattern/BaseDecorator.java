package com.decorator_design_pattern.decorator_with_strategy.notes.decorator_pattern;

public abstract class BaseDecorator implements IPayment {

    public IPayment ip;

    public BaseDecorator(IPayment ip) {
        this.ip = ip;
    }
}
