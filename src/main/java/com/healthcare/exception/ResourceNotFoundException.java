package com.healthcare.exception;

public class ResourceNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;  // 👈 Added line

    public ResourceNotFoundException(String message) {
        super(message);
    }
}
