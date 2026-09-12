package com.vending_machine.practice.machine.exception;

public class InSufficientReserve extends RuntimeException{

    public InSufficientReserve(String message) {
        super(message);
    }
}
