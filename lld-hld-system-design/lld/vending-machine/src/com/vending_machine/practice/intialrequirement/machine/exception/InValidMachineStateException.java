package com.vending_machine.practice.intialrequirement.machine.exception;

public class InValidMachineStateException extends RuntimeException{

    public InValidMachineStateException(String message) {
        super(message);
    }
}
