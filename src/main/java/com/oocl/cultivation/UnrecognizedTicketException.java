package com.oocl.cultivation;

public class UnrecognizedTicketException extends RuntimeException {
    public UnrecognizedTicketException(String message) {
        super(message);
    }
}
