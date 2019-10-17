/**
 * 
 */
package com.schibsted.spain.friends.exception;

/**
 * Exception thrown in case an accept friendship is received with no request sent before.
 *
 * @author hrodriguez
 */
public class InvalidRequestRequiredException extends BaseException {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 6891645857446720497L;

    /**
     * Instantiates a new invalid request required exception.
     */
    public InvalidRequestRequiredException() {
    }

    /**
     * Instantiates a new invalid request required exception.
     *
     * @param message the message
     */
    public InvalidRequestRequiredException(String message) {
        super(message);
    }

}
