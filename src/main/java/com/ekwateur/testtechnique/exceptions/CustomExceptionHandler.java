package com.ekwateur.testtechnique.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * this class is used to handle exceptions.
 */
@RestControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(UnexpectedValueException.class)
    public ProblemDetail handleUnexpectedValueException(UnexpectedValueException e){
        return ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, e.getMessage());
    }

    @ExceptionHandler(UnexpectedClientTypeException.class)
    public ProblemDetail handleUnexpectedClientTypeException(UnexpectedClientTypeException e){
        return ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, e.getMessage());
    }
}
