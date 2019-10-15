/**
 * 
 */
package com.schibsted.spain.friends.exception;

/**
 * Exception thrown in case a received user data with invalid password.
 * 
 * @author hrodriguez
 *
 */
public class InvalidPasswordException extends BaseException {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 6039960479714134758L;

    /**
     * Instantiates a new invalid password exception.
     *
     * @param message the message
     */
    public InvalidPasswordException(String message) {
        super(message);
    }

}
