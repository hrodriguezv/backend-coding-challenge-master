package com.schibsted.spain.friends.service.spec;

/**
 * Defines the operations that should be supported to store/obtain relations between Users.
 * The implementation of this contract belongs to the service layer of this solution.
 * 
 * @author hrodriguez
 */
public interface FriendshipService {

    /**
     * Request friendship.
     *
     * @param userOwner the user owner
     * @param userAdded the user added
     */
    void requestFriendship(String userOwner, String userAdded);

    /**
     * Accept friendship.
     *
     * @param userOwner the user owner
     * @param userAdded the user added
     */
    void acceptFriendship(String userOwner, String userAdded);

    /**
     * Decline friendship.
     *
     * @param userOwner the user owner
     * @param userAdded the user added
     */
    void declineFriendship(String userOwner, String userAdded);

}
