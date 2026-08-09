package com.template_design_pattern.usecase.practice;

public class CashPayment implements IPayment{

    @Override
    public void pay(double amount) {
        System.out.println("Cash payment of amount : "+ amount);
    }
}
