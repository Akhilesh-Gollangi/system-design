package com.parking_lot_lld;

public class NoAvailableSpotException extends RuntimeException{

    public NoAvailableSpotException(String message) {
        super(message);
    }
}
