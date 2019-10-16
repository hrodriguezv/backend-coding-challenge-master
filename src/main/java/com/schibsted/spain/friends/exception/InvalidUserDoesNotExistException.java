/**
 * 
 */
package com.schibsted.spain.friends.exception;

/**
 * @author hrodriguez
 *
 */
public class InvalidUserDoesNotExistException extends BaseException {

    /**
     * 
     */
    private static final long serialVersionUID = -758848998311272302L;

    /**
     * 
     */
    public InvalidUserDoesNotExistException() {
    }

    /**
     * @param message
     */
    public InvalidUserDoesNotExistException(String message) {
        super(message);
    }

}
