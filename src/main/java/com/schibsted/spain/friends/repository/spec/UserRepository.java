package com.schibsted.spain.friends.repository.spec;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.schibsted.spain.friends.model.User;

@Repository
public interface UserRepository {

    Optional<User> findByUserName(String userName);

    public User findByIdAndFetchFriends(String userName);

    User save(User entity);
}
