package com.vending_machine.practice.intialrequirement.machine.exception;

public class InSufficientReserve extends RuntimeException{

    public InSufficientReserve(String message) {
        super(message);
    }
}
