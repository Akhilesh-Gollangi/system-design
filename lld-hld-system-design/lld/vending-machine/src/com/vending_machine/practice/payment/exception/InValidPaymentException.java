package com.vending_machine.practice.payment.exception;

public class InValidPaymentException extends RuntimeException{

    public InValidPaymentException(String message) {
        super(message);
    }
}
