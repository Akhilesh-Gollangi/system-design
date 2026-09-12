package com.vending_machine.practice1.machine.exception;

public class InValidMachineStateException extends RuntimeException{

    public InValidMachineStateException(String message) {
        super(message);
    }
}
