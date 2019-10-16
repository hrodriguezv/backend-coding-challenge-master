/**
 * 
 */
package com.schibsted.spain.friends.exception;

/**
 * @author hrodriguez
 *
 */
public class InvalidRequestRequiredException extends BaseException {

    /**
     * 
     */
    private static final long serialVersionUID = 6891645857446720497L;

    /**
     * 
     */
    public InvalidRequestRequiredException() {
    }

    /**
     * @param message
     */
    public InvalidRequestRequiredException(String message) {
        super(message);
    }

}
