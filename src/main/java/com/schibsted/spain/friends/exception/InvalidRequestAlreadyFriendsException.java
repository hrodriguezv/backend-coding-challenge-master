/**
 * 
 */
package com.schibsted.spain.friends.exception;

/**
 * Exception thrown in case a received a request friendship with an already friendship.
 *
 * @author hrodriguez
 */
public class InvalidRequestAlreadyFriendsException extends BaseException {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -3967813913434047449L;

    /**
     * Instantiates a new invalid request already friends exception.
     */
    public InvalidRequestAlreadyFriendsException() {
    }

    /**
     * Instantiates a new invalid request already friends exception.
     *
     * @param message the message
     */
    public InvalidRequestAlreadyFriendsException(String message) {
        super(message);
    }

}
