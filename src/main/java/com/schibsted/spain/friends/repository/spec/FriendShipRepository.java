package com.schibsted.spain.friends.repository.spec;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.schibsted.spain.friends.model.Friendship;
import com.schibsted.spain.friends.model.FriendshipPK;
import com.schibsted.spain.friends.model.User;

// TODO: Auto-generated Javadoc
/**
 * The Interface FriendShipRepository.
 */
@Repository
public interface FriendShipRepository {

    /**
     * Find friends by user name.
     *
     * @param userName the user name
     * @return the list
     */
    public List<User> findFriendsByUserName(String userName);

    /**
     * Find by id.
     *
     * @param pk the pk
     * @return the optional
     */
    public Optional<Friendship> findById(FriendshipPK pk);

    /**
     * Save.
     *
     * @param entity the entity
     * @return the friendship
     */
    public Friendship save(Friendship entity);

}
