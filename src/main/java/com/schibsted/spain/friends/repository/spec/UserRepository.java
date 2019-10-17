package com.schibsted.spain.friends.repository.spec;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.schibsted.spain.friends.model.User;

/**
 * Defines the operations that should be supported to store/obtain Users.
 * The implementation of this contract belongs to the persistence layer of this solution.
 * 
 * @author hrodriguez
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
