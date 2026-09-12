package com.vending_machine.practice1.payment.exception;

public class InValidPaymentException extends RuntimeException{

    public InValidPaymentException(String message) {
        super(message);
    }
}
