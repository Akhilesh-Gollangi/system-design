package com.vending_machine.practice.intialrequirement.machine.exception;

public class ProductUnavailableException extends RuntimeException{

    public ProductUnavailableException(String message) {
        super(message);
    }
}
