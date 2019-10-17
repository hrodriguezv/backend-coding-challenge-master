/**
 * 
 */
package com.schibsted.spain.friends.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.schibsted.spain.friends.exception.BaseException;
import com.schibsted.spain.friends.exception.InvalidPasswordException;
import com.schibsted.spain.friends.exception.InvalidUserDoesNotExistException;
import com.schibsted.spain.friends.exception.InvalidUserNameException;
import com.schibsted.spain.friends.model.User;
import com.schibsted.spain.friends.repository.spec.FriendShipRepository;
import com.schibsted.spain.friends.repository.spec.UserRepository;
import com.schibsted.spain.friends.service.spec.UserService;
import com.schibsted.spain.friends.util.AdevintaConstants;

/**
 * Implementation of service layer defined to allow the management of users
 * in memory.
 *
 * @author hrodriguez
 */
@Service
public class UserServiceImpl implements UserService {

    /** The user repository. */
    @Autowired
    private UserRepository userRepository;

    /** The friendship repository. */
    @Autowired
    private FriendShipRepository friendshipRepository;

    /**
     * Sign up.
     *
     * @param userName the user name
     * @param pwd the pwd
     * @return the user
     * @throws BaseException the base exception
     */
    @Override
    public User signUp(String userName, String pwd) throws BaseException {

        if (userName == null) {
            throw new InvalidUserNameException(AdevintaConstants.INVALID_USERNAME_NULL);
        }

        if (pwd == null) {
            throw new InvalidUserNameException(AdevintaConstants.INVALID_SC_NULL);
        }

        return userRepository.save(new User(userName, pwd));
    }

    /**
     * List friends by user name.
     *
     * @param userName the user name
     * @param pwd the pwd
     * @return the list
     * @throws BaseException the base exception
     */
    @Override
    public List<User> listFriendsByUserName(String userName, String pwd) throws BaseException {

        if (userName == null) {
            throw new InvalidUserNameException(AdevintaConstants.INVALID_USERNAME_NULL);
        }

        Optional<User> user = userRepository.findByUserName(userName);

        if (user.isPresent()) {

            if (!user.get()
                .getPassword()
                .equals(pwd))
                throw new InvalidPasswordException();

            return friendshipRepository.findFriendsByUserName(user.get()
                .getUserName());

        } else {
            throw new InvalidUserDoesNotExistException();
        }
    }

    /**
     * Find by user name.
     *
     * @param userName the user name
     * @param headerAuth the header auth
     * @return the optional
     */
    @Override
    public Optional<User> findByUserName(String userName, String headerAuth) {
        return userRepository.findByUserName(userName);
    }

}
