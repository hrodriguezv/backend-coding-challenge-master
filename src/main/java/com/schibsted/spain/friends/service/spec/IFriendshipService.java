package com.schibsted.spain.friends.service.spec;

import java.util.Optional;

import com.schibsted.spain.friends.model.Friendship;
import com.schibsted.spain.friends.model.User;

public interface IFriendshipService {

    void requestFriendship(User userOwner, User userAdded);

    void acceptFriendship(User userOwner, User userAdded);

    void declineFriendship(User userOwner, User userAdded);

    Optional<Friendship> findRelation(User userOwner, User userAdded);
}
