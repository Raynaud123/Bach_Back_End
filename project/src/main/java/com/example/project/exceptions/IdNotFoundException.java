package com.example.project.exceptions;

import org.apache.http.HttpStatus;

import java.time.ZonedDateTime;

public class IdNotFoundException {
    private String message;
    private int httpStatus;
    private ZonedDateTime timestamp;

    public IdNotFoundException(String message, int httpStatus, ZonedDateTime timestamp) {
        this.message = message;
        this.httpStatus = httpStatus;
        this.timestamp = timestamp;
    }


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


    public int getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(int httpStatus) {
        this.httpStatus = httpStatus;
    }

    public ZonedDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(ZonedDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
