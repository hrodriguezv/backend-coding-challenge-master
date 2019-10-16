/**
 * 
 */
package com.schibsted.spain.friends.repository.impl;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.schibsted.spain.friends.model.User;
import com.schibsted.spain.friends.repository.spec.UserRepository;

/**
 * @author hrodriguez
 *
 */
@Repository
public class UserRepositoryImpl implements UserRepository {

    /**
     * 
     */
    public UserRepositoryImpl() {
    }

    @Override
    public User save(User entity) {
        return BuiltinMemoryStore.getInstance().addUser(entity.getUserName(), entity);
    }

    @Override
    public Optional<User> findByUserName(String userName) {
        return Optional.ofNullable(BuiltinMemoryStore.getInstance().getUser(userName));
    }

    @Override
    public User findByIdAndFetchFriends(String userName) {
        return null;
    }

}
