package com.schibsted.spain.friends.repository.spec;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.schibsted.spain.friends.model.Friendship;
import com.schibsted.spain.friends.model.FriendshipPK;
import com.schibsted.spain.friends.model.User;

@Repository
public interface FriendShipRepository extends CrudRepository<Friendship, FriendshipPK> {

    public List<User> findFriendsByUserName(String userName);

}
