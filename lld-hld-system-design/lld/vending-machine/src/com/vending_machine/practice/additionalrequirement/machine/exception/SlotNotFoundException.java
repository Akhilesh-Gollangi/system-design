package com.vending_machine.practice.additionalrequirement.machine.exception;

public class SlotNotFoundException extends RuntimeException{

    public SlotNotFoundException(String message) {
        super(message);
    }
}
