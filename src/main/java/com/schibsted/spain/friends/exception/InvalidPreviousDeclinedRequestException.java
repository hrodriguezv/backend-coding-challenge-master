/**
 * 
 */
package com.schibsted.spain.friends.exception;

/**
 * Exception thrown in case a received a repeated declined request.
 *
 * @author hrodriguez
 */
public class InvalidPreviousDeclinedRequestException extends BaseException {


    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -4496410326994512697L;

    /**
     * Instantiates a new invalid previous declined request exception.
     */
    public InvalidPreviousDeclinedRequestException() {
    }

    /**
     * Instantiates a new invalid previous declined request exception.
     *
     * @param message the message
     */
    public InvalidPreviousDeclinedRequestException(String message) {
        super(message);
    }

}
