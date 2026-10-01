package com.example.backend.exception;

public class ConflictStateException extends RuntimeException {
    public ConflictStateException(String message) {
        super(message);
    }
}
