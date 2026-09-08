package com.parking_lot_lld.exception;

public class NoAvailableSpotException extends RuntimeException{

    public NoAvailableSpotException(String message) {
        super(message);
    }
}
