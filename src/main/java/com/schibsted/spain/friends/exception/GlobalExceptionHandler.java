/**
 * 
 */
package com.schibsted.spain.friends.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;

/**
 * Class designed to determine the solution's behavior when encountering an execution error.
 *
 * @author hrodriguez
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(javax.validation.ConstraintViolationException.class)
    public ResponseEntity<Void> handleInvalidUserNameorPasswordException(javax.validation.ConstraintViolationException ex) {
        return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @ExceptionHandler(InvalidFormatException.class)
    public ResponseEntity<Void> handleInvalidFormatException(InvalidFormatException ex) {
        return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @ExceptionHandler(org.hibernate.exception.ConstraintViolationException.class)
    public ResponseEntity<Void> handleSqlException(org.hibernate.exception.ConstraintViolationException ex) {
        return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
    }

}
