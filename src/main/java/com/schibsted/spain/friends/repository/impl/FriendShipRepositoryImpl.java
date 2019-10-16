/**
 * 
 */
package com.schibsted.spain.friends.repository.impl;

import java.util.List;
import java.util.Optional;

import com.schibsted.spain.friends.model.Friendship;
import com.schibsted.spain.friends.model.FriendshipPK;
import com.schibsted.spain.friends.model.User;
import com.schibsted.spain.friends.repository.spec.FriendShipRepository;

/**
 * @author hrodriguez
 *
 */
public class FriendShipRepositoryImpl implements FriendShipRepository {

    /**
     * 
     */
    public FriendShipRepositoryImpl() {
    }

    @Override
    public <S extends Friendship> S save(S entity) {
        return null;
    }

    @Override
    public <S extends Friendship> Iterable<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<Friendship> findById(FriendshipPK id) {
        return null;
    }

    @Override
    public boolean existsById(FriendshipPK id) {
        return false;
    }

    @Override
    public Iterable<Friendship> findAll() {
        return null;
    }

    @Override
    public Iterable<Friendship> findAllById(Iterable<FriendshipPK> ids) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(FriendshipPK id) {

    }

    @Override
    public void delete(Friendship entity) {

    }

    @Override
    public void deleteAll(Iterable<? extends Friendship> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<User> findFriendsByUserName(String userName) {
        // TODO Auto-generated method stub
        return null;
    }

}
