package com.decorator_design_pattern.notes.decorator_with_payment;

public class UPIPayment implements IPayment{

    @Override
    public void pay() {
        System.out.println("Doing payment using UPI");
    }
}
