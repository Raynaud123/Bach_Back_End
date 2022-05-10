package com.example.project.exceptions;

public class NietApprovedRequestException extends Exception {



    public NietApprovedRequestException(String message) {
        super(message);
    }

    public NietApprovedRequestException(String message, Throwable cause) {
        super(message, cause);
    }
}
