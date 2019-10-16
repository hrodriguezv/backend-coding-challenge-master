/**
 * 
 */
package com.schibsted.spain.friends.repository.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.schibsted.spain.friends.model.Friendship;
import com.schibsted.spain.friends.model.FriendshipPK;
import com.schibsted.spain.friends.model.User;
import com.schibsted.spain.friends.repository.spec.FriendShipRepository;

/**
 * @author hrodriguez
 *
 */
@Repository
public class FriendShipRepositoryImpl implements FriendShipRepository {

    /**
     * 
     */
    public FriendShipRepositoryImpl() {
    }

    @Override
    public List<User> findFriendsByUserName(String userName) {
        return null;
    }

    @Override
    public Optional<Friendship> findById(FriendshipPK pk) {
        return null;
    }

    @Override
    public Friendship save(Friendship entity) {
        return null;
    }
}
