/**
 * 
 */
package com.schibsted.spain.friends.exception;

import javax.validation.ConstraintViolationException;

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

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<Void> handleInvalidUserNameorPasswordException(ConstraintViolationException ex) {
        return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @ExceptionHandler(InvalidFormatException.class)
    public ResponseEntity<Void> handleInvalidFormatException(InvalidFormatException ex) {
        return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @ExceptionHandler(InvalidUserNameException.class)
    public ResponseEntity<Void> handleInvalidUserNameException(InvalidUserNameException ex) {
        return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @ExceptionHandler(InvalidPasswordException.class)
    public ResponseEntity<Void> handleInvalidPasswordException(InvalidPasswordException ex) {
        return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @ExceptionHandler(InvalidHimSelfRequestFrienshipException.class)
    public ResponseEntity<Void> handleInvalidHimSelfRequestException(InvalidHimSelfRequestFrienshipException ex) {
        return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @ExceptionHandler(InvalidUserDoesNotExistException.class)
    public ResponseEntity<Void> handleInvalidUserDoesNotExistException(InvalidUserDoesNotExistException ex) {
        return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @ExceptionHandler(InvalidPreviousRequestSentException.class)
    public ResponseEntity<Void> handleInvalidPreviousRequestSentException(InvalidPreviousRequestSentException ex) {
        return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @ExceptionHandler(InvalidRequestAlreadyFriendsException.class)
    public ResponseEntity<Void> handleInvalidRequestAlreadyFriendsException(InvalidRequestAlreadyFriendsException ex) {
        return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @ExceptionHandler(InvalidRequestRequiredException.class)
    public ResponseEntity<Void> handleInvalidRequestRequiredException(InvalidRequestRequiredException ex) {
        return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @ExceptionHandler(InvalidPreviousDeclinedRequestException.class)
    public ResponseEntity<Void> handleInvalidPreviousRequestException(InvalidPreviousDeclinedRequestException ex) {
        return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
    }

}
