package com.oocl.cultivation;

public class NotEnoughCapacity extends RuntimeException{
    public NotEnoughCapacity(String message) {
        super(message);
    }
}
