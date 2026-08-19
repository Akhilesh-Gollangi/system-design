package com.decorator_design_pattern.assignment.practice.decorator_with_pament;

public class UPIPayment implements IPayment {
    @Override
    public void pay() {
        System.out.println("Payment made using UPI.");
    }
}