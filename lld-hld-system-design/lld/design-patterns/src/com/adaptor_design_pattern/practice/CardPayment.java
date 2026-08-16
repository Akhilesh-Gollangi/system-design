package com.adaptor_design_pattern.practice;

public class CardPayment implements IPayment {
    @Override
    public void pay() {
        System.out.println("Payment made using Card.");
    }
}