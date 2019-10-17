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
import com.schibsted.spain.friends.service.spec.FriendshipService;

/**
 * Implementation of service layer defined to allow the management of relations between users
 * in memory.
 * 
 * @author hrodriguez
 */
@Service
public class FriendshipServiceImpl implements FriendshipService {

    /** The fr repository. */
    @Autowired
    private FriendShipRepository frRepository;

    /** The usr repository. */
    @Autowired
    private UserRepository usrRepository;

    /**
     * Request friendship.
     *
     * @param userOwner the user owner
     * @param userAdded the user added
     */
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
            });

        frRepository.save(new Friendship(userFrom, userTo, FriendshipStatus.REQUESTED));
    }

    /**
     * Accept friendship.
     *
     * @param userOwner the user owner
     * @param userAdded the user added
     */
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

    /**
     * Decline friendship.
     *
     * @param userOwner the user owner
     * @param userAdded the user added
     */
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
        } else {
            throw new InvalidRequestRequiredException();
        }

    }

}
