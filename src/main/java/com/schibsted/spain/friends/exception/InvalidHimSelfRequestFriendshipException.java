/**
 * 
 */
package com.schibsted.spain.friends.exception;

/**
 * Exception thrown in case a received request friendship from same user.
 *
 * @author hrodriguez
 */
public class InvalidHimSelfRequestFriendshipException extends BaseException {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 2153342451180060447L;

    /**
     * Instantiates a new invalid him self request friendship exception.
     */
    public InvalidHimSelfRequestFriendshipException() {
    }

    /**
     * Instantiates a new invalid him self request frienship exception.
     *
     * @param message the message
     */
    public InvalidHimSelfRequestFriendshipException(String message) {
        super(message);
    }

}
