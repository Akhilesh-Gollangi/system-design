package com.vending_machine.practice.machine.exception;

public class SlotNotFoundException extends RuntimeException{

    public SlotNotFoundException(String message) {
        super(message);
    }
}
