package com.oocl.cultivation.Exception;

public class MissingTicketException extends RuntimeException {
    public MissingTicketException(String message) {
        super(message);
    }
}
