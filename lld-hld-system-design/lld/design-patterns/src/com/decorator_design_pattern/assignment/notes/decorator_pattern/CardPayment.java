package com.decorator_design_pattern.assignment.notes.decorator_pattern;

public class CardPayment implements IPayment {
    @Override
    public void pay() {
        System.out.println("Doing payment using UPI");
    }
}
