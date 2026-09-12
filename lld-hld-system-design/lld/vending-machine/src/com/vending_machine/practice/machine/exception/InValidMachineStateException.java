package com.vending_machine.practice.machine.exception;

public class InValidMachineStateException extends RuntimeException{

    public InValidMachineStateException(String message) {
        super(message);
    }
}
