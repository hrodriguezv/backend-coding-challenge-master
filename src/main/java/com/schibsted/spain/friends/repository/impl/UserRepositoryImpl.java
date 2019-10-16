/**
 * 
 */
package com.schibsted.spain.friends.repository.impl;

import java.util.Optional;

import com.schibsted.spain.friends.model.User;
import com.schibsted.spain.friends.repository.spec.UserRepository;

/**
 * @author hrodriguez
 *
 */
public class UserRepositoryImpl implements UserRepository {

    /**
     * 
     */
    public UserRepositoryImpl() {
    }

    @Override
    public <S extends User> S save(S entity) {
        return null;
    }

    @Override
    public <S extends User> Iterable<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<User> findById(Long id) {
        return null;
    }

    @Override
    public boolean existsById(Long id) {
        return false;
    }

    @Override
    public Iterable<User> findAll() {
        return null;
    }

    @Override
    public Iterable<User> findAllById(Iterable<Long> ids) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public void delete(User entity) {

    }

    @Override
    public void deleteAll(Iterable<? extends User> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public Long count(String name) {
        return null;
    }

    @Override
    public Optional<User> findByUserName(String userName) {
        return null;
    }

    @Override
    public User findByIdAndFetchFriends(Long id) {
        return null;
    }

}
