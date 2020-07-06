package com.labs.challenge.controllers;

import com.labs.challenge.exceptions.UniqueEmailException;
import com.labs.challenge.response.ResponseError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import javax.xml.ws.Response;
import java.time.LocalDateTime;


@ControllerAdvice
public class ChallengeExceptionHandler {

    @ExceptionHandler(value = { UniqueEmailException.class })
    protected ResponseEntity<?> handleMessageNotReadableException(UniqueEmailException exception) {
        ResponseError responseError = new ResponseError();
        responseError.setDetails(exception.getMessage());
        responseError.setTimestamp(LocalDateTime.now());
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(responseError);
    }
}
