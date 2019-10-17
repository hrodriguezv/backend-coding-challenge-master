package com.schibsted.spain.friends.service.spec;

public interface IFriendshipService {

    void requestFriendship(String userOwner, String userAdded);

    void acceptFriendship(String userOwner, String userAdded);

    void declineFriendship(String userOwner, String userAdded);

}
