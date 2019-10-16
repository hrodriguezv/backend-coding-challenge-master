/**
 * 
 */
package com.schibsted.spain.friends.exception;

/**
 * @author hrodriguez
 *
 */
public class InvalidRequestAlreadyFriendsException extends BaseException {

    /**
     * 
     */
    private static final long serialVersionUID = -3967813913434047449L;

    /**
     * 
     */
    public InvalidRequestAlreadyFriendsException() {
    }

    /**
     * @param message
     */
    public InvalidRequestAlreadyFriendsException(String message) {
        super(message);
    }

}
