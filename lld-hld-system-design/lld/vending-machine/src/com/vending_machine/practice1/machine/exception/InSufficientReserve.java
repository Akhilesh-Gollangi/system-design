package com.vending_machine.practice1.machine.exception;

public class InSufficientReserve extends RuntimeException{

    public InSufficientReserve(String message) {
        super(message);
    }
}
