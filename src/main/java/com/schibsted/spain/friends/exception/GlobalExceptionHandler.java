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

    /**
     * Handle invalid user nameor password exception.
     *
     * @param ex the ex
     * @return the response entity
     */
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<Void> handleInvalidUserNameorPasswordException(ConstraintViolationException ex) {
        return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
    }

    /**
     * Handle invalid format exception.
     *
     * @param ex the ex
     * @return the response entity
     */
    @ExceptionHandler(InvalidFormatException.class)
    public ResponseEntity<Void> handleInvalidFormatException(InvalidFormatException ex) {
        return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
    }

    /**
     * Handle invalid user name exception.
     *
     * @param ex the ex
     * @return the response entity
     */
    @ExceptionHandler(InvalidUserNameException.class)
    public ResponseEntity<Void> handleInvalidUserNameException(InvalidUserNameException ex) {
        return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
    }

    /**
     * Handle invalid password exception.
     *
     * @param ex the ex
     * @return the response entity
     */
    @ExceptionHandler(InvalidPasswordException.class)
    public ResponseEntity<Void> handleInvalidPasswordException(InvalidPasswordException ex) {
        return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
    }

    /**
     * Handle invalid him self request exception.
     *
     * @param ex the ex
     * @return the response entity
     */
    @ExceptionHandler(InvalidHimSelfRequestFriendshipException.class)
    public ResponseEntity<Void> handleInvalidHimSelfRequestException(InvalidHimSelfRequestFriendshipException ex) {
        return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
    }

    /**
     * Handle invalid user does not exist exception.
     *
     * @param ex the ex
     * @return the response entity
     */
    @ExceptionHandler(InvalidUserDoesNotExistException.class)
    public ResponseEntity<Void> handleInvalidUserDoesNotExistException(InvalidUserDoesNotExistException ex) {
        return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
    }

    /**
     * Handle invalid previous request sent exception.
     *
     * @param ex the ex
     * @return the response entity
     */
    @ExceptionHandler(InvalidPreviousRequestSentException.class)
    public ResponseEntity<Void> handleInvalidPreviousRequestSentException(InvalidPreviousRequestSentException ex) {
        return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
    }

    /**
     * Handle invalid request already friends exception.
     *
     * @param ex the ex
     * @return the response entity
     */
    @ExceptionHandler(InvalidRequestAlreadyFriendsException.class)
    public ResponseEntity<Void> handleInvalidRequestAlreadyFriendsException(InvalidRequestAlreadyFriendsException ex) {
        return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
    }

    /**
     * Handle invalid request required exception.
     *
     * @param ex the ex
     * @return the response entity
     */
    @ExceptionHandler(InvalidRequestRequiredException.class)
    public ResponseEntity<Void> handleInvalidRequestRequiredException(InvalidRequestRequiredException ex) {
        return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
    }

    /**
     * Handle invalid previous request exception.
     *
     * @param ex the ex
     * @return the response entity
     */
    @ExceptionHandler(InvalidPreviousDeclinedRequestException.class)
    public ResponseEntity<Void> handleInvalidPreviousRequestException(InvalidPreviousDeclinedRequestException ex) {
        return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
    }

}
