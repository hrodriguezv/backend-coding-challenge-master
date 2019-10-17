/**
 * 
 */
package com.schibsted.spain.friends.exception;

/**
 * Exception thrown in case of process a request from a user has not been registered.
 *
 * @author hrodriguez
 */
public class InvalidUserDoesNotExistException extends BaseException {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -758848998311272302L;

    /**
     * Instantiates a new invalid user does not exist exception.
     */
    public InvalidUserDoesNotExistException() {
    }

    /**
     * Instantiates a new invalid user does not exist exception.
     *
     * @param message the message
     */
    public InvalidUserDoesNotExistException(String message) {
        super(message);
    }

}
