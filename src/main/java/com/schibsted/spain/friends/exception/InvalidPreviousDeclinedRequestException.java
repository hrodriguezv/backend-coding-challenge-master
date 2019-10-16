/**
 * 
 */
package com.schibsted.spain.friends.exception;

/**
 * @author hrodriguez
 *
 */
public class InvalidPreviousDeclinedRequestException extends BaseException {


    /**
     * 
     */
    private static final long serialVersionUID = -4496410326994512697L;

    /**
     * 
     */
    public InvalidPreviousDeclinedRequestException() {
    }

    /**
     * @param message
     */
    public InvalidPreviousDeclinedRequestException(String message) {
        super(message);
    }

}
