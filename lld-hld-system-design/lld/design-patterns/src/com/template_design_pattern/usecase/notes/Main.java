package com.template_design_pattern.usecase.notes;

public class Main {
    public static void main(String[] args) {
        PaymentProcessor processor =  new CashPaymentProcessor();
        processor.processOrder(500.0);
    }
}