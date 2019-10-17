package com.schibsted.spain.friends.repository.spec;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.schibsted.spain.friends.model.User;

// TODO: Auto-generated Javadoc
/**
 * The Interface UserRepository.
 */
@Repository
public interface UserRepository {

    /**
     * Find by user name.
     *
     * @param userName the user name
     * @return the optional
     */
    Optional<User> findByUserName(String userName);

    /**
     * Find by id and fetch friends.
     *
     * @param userName the user name
     * @return the user
     */
    public User findByIdAndFetchFriends(String userName);

    /**
     * Save.
     *
     * @param entity the entity
     * @return the user
     */
    User save(User entity);
}
