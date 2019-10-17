/**
 * 
 */
package com.schibsted.spain.friends.repository.impl;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.schibsted.spain.friends.model.User;
import com.schibsted.spain.friends.repository.spec.UserRepository;

/**
 * Implementation of persistent layer defined to allow the management of users
 * in memory.
 * 
 * @author hrodriguez
 */
@Repository
public class UserRepositoryImpl implements UserRepository {

    /**
     * Save.
     *
     * @param entity the entity
     * @return the user
     */
    @Override
    public User save(User entity) {
        return BuiltinMemoryStore.getInstance().addUser(entity.getUserName(), entity);
    }

    /**
     * Find by user name.
     *
     * @param userName the user name
     * @return the optional
     */
    @Override
    public Optional<User> findByUserName(String userName) {
        return Optional.ofNullable(BuiltinMemoryStore.getInstance().getUser(userName));
    }

    /**
     * Find by id and fetch friends.
     *
     * @param userName the user name
     * @return the user
     */
    @Override
    public User findByIdAndFetchFriends(String userName) {
        return null;
    }

}
