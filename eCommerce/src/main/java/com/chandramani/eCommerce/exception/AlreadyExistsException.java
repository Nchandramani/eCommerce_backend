package com.chandramani.eCommerce.exception;

public class AlreadyExistsException extends RuntimeException  {
    public AlreadyExistsException(String message) {
        super(message);
    }
}
