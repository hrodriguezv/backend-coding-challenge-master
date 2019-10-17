package com.schibsted.spain.friends.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.schibsted.spain.friends.exception.InvalidPreviousRequestSentException;
import com.schibsted.spain.friends.exception.InvalidRequestAlreadyFriendsException;
import com.schibsted.spain.friends.exception.InvalidRequestRequiredException;
import com.schibsted.spain.friends.exception.InvalidUserDoesNotExistException;
import com.schibsted.spain.friends.model.Friendship;
import com.schibsted.spain.friends.model.FriendshipPK;
import com.schibsted.spain.friends.model.FriendshipStatus;
import com.schibsted.spain.friends.model.User;
import com.schibsted.spain.friends.repository.spec.FriendShipRepository;
import com.schibsted.spain.friends.repository.spec.UserRepository;
import com.schibsted.spain.friends.service.spec.IFriendshipService;

@Service
public class FriendshipServiceImpl implements IFriendshipService {

    @Autowired
    private FriendShipRepository frRepository;

    @Autowired
    private UserRepository usrRepository;

    @Override
    public void requestFriendship(String userOwner, String userAdded) {

        User userFrom = usrRepository.findByUserName(userOwner)
            .orElseThrow(InvalidUserDoesNotExistException::new);
        User userTo = usrRepository.findByUserName(userAdded)
            .orElseThrow(InvalidUserDoesNotExistException::new);

        frRepository.findById(new FriendshipPK(userFrom, userTo))
            .ifPresent(relation -> {
                FriendshipStatus status = relation.getStatus();

                if (status.equals(FriendshipStatus.REQUESTED)) {
                    throw new InvalidPreviousRequestSentException();
                } else if (status.equals(FriendshipStatus.ACCEPTED)) {
                    throw new InvalidRequestAlreadyFriendsException();
                } else {
                    relation.setStatus(FriendshipStatus.REQUESTED);
                }

                frRepository.save(relation);
                return;
            });

        frRepository.save(new Friendship(userFrom, userTo, FriendshipStatus.REQUESTED));
    }

    @Override
    public void acceptFriendship(String userOwner, String userAdded) {

        User userFrom = usrRepository.findByUserName(userOwner)
            .orElseThrow(InvalidUserDoesNotExistException::new);
        User userTo = usrRepository.findByUserName(userAdded)
            .orElseThrow(InvalidUserDoesNotExistException::new);

        Optional<Friendship> previousRelation = frRepository.findById(new FriendshipPK(userTo, userFrom));

        if (previousRelation.isPresent()) {
            Friendship relation = previousRelation.get();
            FriendshipStatus status = relation.getStatus();

            if (status.equals(FriendshipStatus.ACCEPTED)) {
                throw new InvalidRequestAlreadyFriendsException();
            } else if (status.equals(FriendshipStatus.DECLINED)) {
                throw new InvalidRequestRequiredException();
            } else if (status.equals(FriendshipStatus.REQUESTED)) {
                relation.setStatus(FriendshipStatus.ACCEPTED);
                frRepository.save(relation);

                Friendship approvedInverse = new Friendship(userFrom, userTo, FriendshipStatus.ACCEPTED);
                frRepository.save(approvedInverse);
            }

        } else {
            throw new InvalidRequestRequiredException();
        }

    }

    @Override
    public void declineFriendship(String userOwner, String userAdded) {

        User userFrom = usrRepository.findByUserName(userOwner)
            .orElseThrow(InvalidUserDoesNotExistException::new);
        User userTo = usrRepository.findByUserName(userAdded)
            .orElseThrow(InvalidUserDoesNotExistException::new);

        Optional<Friendship> previousRelation = frRepository.findById(new FriendshipPK(userTo, userFrom));

        if (previousRelation.isPresent()) {
            Friendship relation = previousRelation.get();
            FriendshipStatus status = relation.getStatus();

            if (status.equals(FriendshipStatus.ACCEPTED)) {
                throw new InvalidRequestAlreadyFriendsException();
            } else if (status.equals(FriendshipStatus.DECLINED)) {
                throw new InvalidRequestRequiredException();
            } else if (status.equals(FriendshipStatus.REQUESTED)) {
                relation.setStatus(FriendshipStatus.DECLINED);
                frRepository.save(relation);
            }
            return;
        } else {
            throw new InvalidRequestRequiredException();
        }

    }

}
