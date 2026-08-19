package com.decorator_design_pattern.decorator_with_strategy.practice.decorator_with_pament;

public class UPIPayment implements IPayment {
    @Override
    public void pay() {
        System.out.println("Payment made using UPI.");
    }
}