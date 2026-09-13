package com.vending_machine.practice.intialrequirement.machine.exception;

public class SlotNotFoundException extends RuntimeException{

    public SlotNotFoundException(String message) {
        super(message);
    }
}
