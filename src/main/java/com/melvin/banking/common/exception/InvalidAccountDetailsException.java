package com.melvin.banking.common.exception;

public class InvalidAccountDetailsException extends RuntimeException {
    public InvalidAccountDetailsException(String message) {
        super(message);
    }
}
