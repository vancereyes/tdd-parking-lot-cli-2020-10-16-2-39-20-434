package com.oocl.cultivation;

public class MissingTicketException extends RuntimeException {
    public MissingTicketException(String message) {
        super(message);
    }
}
