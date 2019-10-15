package com.schibsted.spain.friends.service.spec;

import com.schibsted.spain.friends.model.User;

public interface IFriendshipService {

    void requestFriendship(User userOwner, User userAdded);
    
    void acceptFriendship(User userOwner, User userAdded);
    
    void declineFriendship(User userOwner, User userAdded);

}
