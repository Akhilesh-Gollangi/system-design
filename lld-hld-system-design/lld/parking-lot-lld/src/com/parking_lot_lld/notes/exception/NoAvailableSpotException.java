package com.parking_lot_lld.notes.exception;

public class NoAvailableSpotException extends RuntimeException{

    public NoAvailableSpotException(String message){
        super(message);
    }
}
