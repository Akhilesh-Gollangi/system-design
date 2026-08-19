package com.decorator_design_pattern.decorator_with_strategy.notes.decorator_pattern;

public class UPIPayment implements IPayment{

    @Override
    public void pay() {
        System.out.println("Doing payment using UPI");
    }
}
