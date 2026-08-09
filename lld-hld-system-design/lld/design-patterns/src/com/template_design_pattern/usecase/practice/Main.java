package com.template_design_pattern.usecase.practice;

/*
    Use case : Payment processor
    we have different payment methods like credit card, UPI, cash etc.
    We have process order where we have to validate, otp verification, payment and log the transaction.
    we have follow the same order of execution for all payment methods.

    As we have same order of execution for all payment methods.
    To acheive order we will create method and call them sequentially in process order method in every payment processor class.
    But this will lead to code duplication and if we have to change the order of execution then we have to change in all payment processor classes.

    Template Design Pattern instead keeping process order function in every child class kept in parent class
    Thats means keeps away receipe from child classes and keeps in parent class. So that we can have a common receipe for all child classes.

 */
public class Main {

    public static void main(String[] args) {

        PaymentProcessor paymentProcessor = new CardPaymentProcessor();
        paymentProcessor.processOrder(500.0);

        System.out.println("=================================================");
        //cashPayment we have set OTP verification as false
        PaymentProcessor processor = new CashPaymentProcessor();
        processor.processOrder(100.0);



    }
}
