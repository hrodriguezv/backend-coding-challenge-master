package com.schibsted.spain.friends.repository.spec;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.schibsted.spain.friends.model.Friendship;
import com.schibsted.spain.friends.model.FriendshipPK;
import com.schibsted.spain.friends.model.User;

@Repository
public interface FriendShipRepository {

    public List<User> findFriendsByUserName(String userName);

    public Optional<Friendship> findById(FriendshipPK pk);

    public Friendship save(Friendship entity);

}
