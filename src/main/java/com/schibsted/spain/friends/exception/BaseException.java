package com.schibsted.spain.friends.exception;

/**
 * Superclass of those exceptions that can be thrown during the reception of data from API, 
 * following the business rules established to solve this problem.
 *  
 *  @author hrodriguez
 */
public class BaseException extends RuntimeException {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -5681622376857881625L;

    /**
     * Instantiates a new base exception.
     */
    public BaseException() {
        super(BaseException.class.getSimpleName() + ": There was an error processing this entity");
    }

    /**
     * Instantiates a new base exception.
     *
     * @param message the message
     */
    public BaseException(String message) {
        super(message);
    }
}
