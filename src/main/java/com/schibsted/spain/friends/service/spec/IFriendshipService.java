package com.schibsted.spain.friends.service.spec;

// TODO: Auto-generated Javadoc
/**
 * The Interface IFriendshipService.
 */
public interface IFriendshipService {

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
