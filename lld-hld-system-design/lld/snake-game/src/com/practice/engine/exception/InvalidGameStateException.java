package com.practice.engine.exception;

public class InvalidGameStateException extends RuntimeException{

    public InvalidGameStateException(String message) {
        super(message);
    }
}
