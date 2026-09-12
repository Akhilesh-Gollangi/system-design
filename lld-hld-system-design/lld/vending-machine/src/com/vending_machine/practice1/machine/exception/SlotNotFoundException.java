package com.vending_machine.practice1.machine.exception;

public class SlotNotFoundException extends RuntimeException{

    public SlotNotFoundException(String message) {
        super(message);
    }
}
