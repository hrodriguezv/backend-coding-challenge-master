package com.schibsted.spain.friends.service.impl;

import java.time.Clock;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.schibsted.spain.friends.exception.InvalidPreviousDeclinedRequestException;
import com.schibsted.spain.friends.exception.InvalidRequestRequiredException;
import com.schibsted.spain.friends.model.Friendship;
import com.schibsted.spain.friends.model.FriendshipPK;
import com.schibsted.spain.friends.model.FriendshipStatus;
import com.schibsted.spain.friends.model.User;
import com.schibsted.spain.friends.repository.spec.IFriendShipRepository;
import com.schibsted.spain.friends.service.spec.IFriendshipService;

@Service
public class FriendshipServiceImpl implements IFriendshipService {

    @Autowired
    private IFriendShipRepository repository;

    @Override
    public void requestFriendship(User userOwner, User userAdded) {
        Friendship requestedFriendship = null;
        Optional<Friendship> relation = repository.findById(new FriendshipPK(userOwner, userAdded));

        if (relation.isPresent()) {
            requestedFriendship = relation.get();

            if (requestedFriendship.getStatus()
                .equals(FriendshipStatus.DECLINED)) {

                requestedFriendship.setStatus(FriendshipStatus.REQUESTED);
                requestedFriendship.setUpdated(Clock.systemDefaultZone()
                    .instant());

            } else {
                throw new InvalidPreviousDeclinedRequestException();
            }
        } else {
            requestedFriendship = new Friendship(userOwner, userAdded, FriendshipStatus.REQUESTED);
        }

        repository.saveAndFlush(requestedFriendship);
    }

    @Override
    public void acceptFriendship(User userOwner, User userAdded) {

        Optional<Friendship> relation = repository.findById(new FriendshipPK(userAdded, userOwner));

        if (relation.isPresent()) {

            Friendship requestedFriendship = relation.get();

            if (requestedFriendship.getStatus()
                .equals(FriendshipStatus.REQUESTED)) {

                requestedFriendship.setStatus(FriendshipStatus.ACCEPTED);
                requestedFriendship.setUpdated(Clock.systemDefaultZone()
                    .instant());
                repository.saveAndFlush(requestedFriendship);
                return;

            }
        }

        throw new InvalidRequestRequiredException();
    }

    @Override
    public void declineFriendship(User userOwner, User userAdded) {

        Optional<Friendship> relation = repository.findById(new FriendshipPK(userAdded, userOwner));

        if (relation.isPresent()) {

            Friendship requestedFriendship = relation.get();

            if (requestedFriendship.getStatus()
                .equals(FriendshipStatus.REQUESTED)) {

                requestedFriendship.setStatus(FriendshipStatus.DECLINED);
                requestedFriendship.setUpdated(Clock.systemDefaultZone()
                    .instant());
                repository.saveAndFlush(requestedFriendship);
                return;
            }

        }

        throw new InvalidRequestRequiredException();
    }

    @Override
    public Optional<Friendship> findRelation(User userOwner, User userAdded) {
        return repository.findById(new FriendshipPK(userOwner, userAdded));
    }

}
