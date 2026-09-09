package com.parking_lot_lld.practice.exception;

public class NoAvailableSpotException extends RuntimeException{

    public NoAvailableSpotException(String message) {
        super(message);
    }
}
