package com.vending_machine.practice.payment.exception;

public class InvalidPayment extends RuntimeException{

    public InvalidPayment(String message) {
        super(message);
    }
}
