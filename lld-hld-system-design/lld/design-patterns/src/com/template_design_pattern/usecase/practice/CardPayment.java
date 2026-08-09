package com.template_design_pattern.usecase.practice;

public class CardPayment implements IPayment{

    @Override
    public void pay(double amount) {
        System.out.println("Card payment of amount : "+ amount);
    }
}
