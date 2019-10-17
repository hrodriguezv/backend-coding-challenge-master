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

// TODO: Auto-generated Javadoc
/**
 * The Class FriendShipRepositoryImpl.
 *
 * @author hrodriguez
 */
@Repository
public class FriendShipRepositoryImpl implements FriendShipRepository {

    /**
     * Find friends by user name.
     *
     * @param userName the user name
     * @return the list
     */
    @Override
    public List<User> findFriendsByUserName(String userName) {
        return BuiltinMemoryStore.getInstance().getFriendsListByUserName(userName);
    }

    /**
     * Find by id.
     *
     * @param pk the pk
     * @return the optional
     */
    @Override
    public Optional<Friendship> findById(FriendshipPK pk) {
        return Optional.ofNullable(BuiltinMemoryStore.getInstance().getRelationship(pk));
    }

    /**
     * Save.
     *
     * @param entity the entity
     * @return the friendship
     */
    @Override
    public Friendship save(Friendship entity) {
        return BuiltinMemoryStore.getInstance()
            .addFriendship(entity.getPk(), entity);
    }
}
