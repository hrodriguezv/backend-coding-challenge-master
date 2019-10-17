/**
 * 
 */
package com.schibsted.spain.friends.exception;

// TODO: Auto-generated Javadoc
/**
 * Exception thrown in case a received user data with invalid user name.
 * 
 * @author hrodriguez
 *
 */
public class InvalidUserNameException extends BaseException {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 8210064483815857022L;

    
    /**
     * Instantiates a new invalid user name exception.
     *
     * @param message the message
     */
    public InvalidUserNameException(String message) {
        super(message);
    }

}
