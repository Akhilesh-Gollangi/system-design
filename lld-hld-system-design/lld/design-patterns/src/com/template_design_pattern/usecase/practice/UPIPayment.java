package com.template_design_pattern.usecase.practice;

public class UPIPayment implements IPayment {

    @Override
    public void pay(double amount) {
        System.out.println("UPI payment of amount : "+ amount);
    }
}
