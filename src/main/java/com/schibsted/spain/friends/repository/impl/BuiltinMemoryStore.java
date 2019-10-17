/**
 * 
 */
package com.schibsted.spain.friends.repository.impl;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validation;
import javax.validation.ValidatorFactory;

import org.springframework.stereotype.Component;

import com.schibsted.spain.friends.exception.BaseException;
import com.schibsted.spain.friends.exception.InvalidPasswordException;
import com.schibsted.spain.friends.exception.InvalidUserNameException;
import com.schibsted.spain.friends.model.Friendship;
import com.schibsted.spain.friends.model.FriendshipPK;
import com.schibsted.spain.friends.model.FriendshipStatus;
import com.schibsted.spain.friends.model.User;
import com.schibsted.spain.friends.util.AdevintaConstants;

// TODO: Auto-generated Javadoc
/**
 * The Class BuiltinMemoryStore.
 *
 * @author hrodriguez
 */
@Component
public class BuiltinMemoryStore {

    /** The users. */
    private Map<String, User> users;

    /** The relations. */
    private Map<FriendshipPK, Friendship> relations;

    /** The instance. */
    private static BuiltinMemoryStore instance;

    /** The mutex. */
    private static Object mutex = new Object();

    /** The validator factory. */
    private ValidatorFactory validatorFactory;

    /**
     * Instantiates a new builtin memory store.
     */
    private BuiltinMemoryStore() {
        validatorFactory = Validation.buildDefaultValidatorFactory();
        users = new ConcurrentHashMap<>();
        relations = new ConcurrentHashMap<>();
    }

    /**
     * Gets the single instance of BuiltinMemoryStore.
     *
     * @return single instance of BuiltinMemoryStore
     */
    public static BuiltinMemoryStore getInstance() {

        BuiltinMemoryStore result = instance;

        if (result == null) {

            synchronized (mutex) {
                result = instance;

                if (result == null) {
                    instance = result = new BuiltinMemoryStore();
                }

            }

        }

        return result;
    }

    /**
     * Manage base exception.
     *
     * @param message the message
     */
    private void manageBaseException(String message) {
        switch (message) {
        case AdevintaConstants.INVALID_SC_NULL:
        case AdevintaConstants.INVALID_SC_FORMAT:
        case AdevintaConstants.INVALID_SC_LENGTH:
            throw new InvalidPasswordException(message);
        case AdevintaConstants.INVALID_USERNAME_NULL:
        case AdevintaConstants.INVALID_USERNAME_FORMAT:
        case AdevintaConstants.INVALID_USERNAME_LENGTH:
            throw new InvalidUserNameException(message);
        default:
            throw new BaseException();
        }
    }

    /**
     * Adds the user.
     *
     * @param key the key
     * @param value the value
     * @return the user
     */
    public User addUser(String key, User value) {

        Set<ConstraintViolation<User>> violations = validatorFactory.getValidator()
            .validate(value);

        if (!violations.isEmpty())
            manageBaseException(violations.iterator()
                .next()
                .getMessage());

        if (instance.users.get(key) != null)
            throw new ConstraintViolationException("unique constraint :" + key, Collections.emptySet());

        instance.users.putIfAbsent(key, value);

        return instance.users.get(key);
    }

    /**
     * Update user.
     *
     * @param key the key
     * @param value the value
     * @return the user
     */
    public User updateUser(String key, User value) {
        return instance.users.replace(key, value);
    }

    /**
     * Gets the user.
     *
     * @param key the key
     * @return the user
     */
    public User getUser(String key) {
        return instance.users.get(key);
    }

    /**
     * Adds the friendship.
     *
     * @param key the key
     * @param value the value
     * @return the friendship
     */
    public Friendship addFriendship(FriendshipPK key, Friendship value) {
        instance.relations.putIfAbsent(key, value);
        return instance.relations.get(key);
    }

    /**
     * Update friendship.
     *
     * @param key the key
     * @param value the value
     * @return the friendship
     */
    public Friendship updateFriendship(FriendshipPK key, Friendship value) {
        return instance.relations.replace(key, value);
    }

    /**
     * Gets the relationship.
     *
     * @param key the key
     * @return the relationship
     */
    public Friendship getRelationship(FriendshipPK key) {
        return instance.relations.get(key);
    }

    /**
     * Gets the friends list by user name.
     *
     * @param userName the user name
     * @return the friends list by user name
     */
    public List<User> getFriendsListByUserName(String userName) {
        return relations.values()
            .stream()
            .filter(fr -> fr.getPk()
                .getOwner()
                .getUserName()
                .equals(userName)
                && fr.getStatus()
                    .equals(FriendshipStatus.ACCEPTED))
            .map(fr -> fr.getPk()
                .getFriend())
            .sorted(User::compareByReverseUserName)
            .collect(Collectors.toList());
    }
}
