/**
 * 
 */
package com.schibsted.spain.friends.exception;

/**
 * Exception thrown in case a received a friendship request with a previous one active.
 *
 * @author hrodriguez
 */
public class InvalidPreviousRequestSentException extends BaseException {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 9140148071821526822L;

    /**
     * Instantiates a new invalid previous request sent exception.
     */
    public InvalidPreviousRequestSentException() {
    }

    /**
     * Instantiates a new invalid previous request sent exception.
     *
     * @param message the message
     */
    public InvalidPreviousRequestSentException(String message) {
        super(message);
    }

}
