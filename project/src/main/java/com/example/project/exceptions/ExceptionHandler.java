package com.example.project.exceptions;

import org.apache.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@ControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(value = {NietApprovedRequestException.class})
    public ResponseEntity<Object> NietApprovedException(NietApprovedRequestException e){
        //create payload
        NietApprovedException z = new NietApprovedException(e.getMessage(), HttpStatus.SC_UNAUTHORIZED, ZonedDateTime.now(ZoneId.of("Z")));
        //return response
        return new ResponseEntity<Object>(z, org.springframework.http.HttpStatus.valueOf(HttpStatus.SC_UNAUTHORIZED));
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(value = {IdNotFoundRequestException.class})
    public ResponseEntity<Object> IdNotFoundException(IdNotFoundRequestException e){
        //create payload
        IdNotFoundException z = new IdNotFoundException(e.getMessage(), HttpStatus.SC_BAD_REQUEST, ZonedDateTime.now(ZoneId.of("Z")));
        //return response
        return new ResponseEntity<Object>(z, org.springframework.http.HttpStatus.valueOf(HttpStatus.SC_BAD_REQUEST));
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(value = {NietTop3TopicExceptionRequest.class})
    public ResponseEntity<Object> NietTop3TopicException(NietTop3TopicExceptionRequest e){
        //create payload
        NietTop3TopicException z = new NietTop3TopicException(e.getMessage(), HttpStatus.SC_BAD_REQUEST, ZonedDateTime.now(ZoneId.of("Z")));
        //return response
        return new ResponseEntity<Object>(z, org.springframework.http.HttpStatus.valueOf(HttpStatus.SC_BAD_REQUEST));
    }

}
