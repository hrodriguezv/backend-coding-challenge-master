/**
 * 
 */
package com.schibsted.spain.friends.service.impl;

import java.util.Collections;
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
import com.schibsted.spain.friends.service.spec.IUserService;
import com.schibsted.spain.friends.util.AdevintaConstants;

/**
 * @author hrodriguez
 *
 */
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private FriendShipRepository friendshipRepository;

    @Override
    public User signUp(String userName, String pwd) throws BaseException {

        if (userName == null) {
            throw new InvalidUserNameException(AdevintaConstants.INVALID_USERNAME_NULL);
        }

        if (pwd == null) {
            throw new InvalidUserNameException(AdevintaConstants.INVALID_PWD_NULL);
        }

        return userRepository.save(new User(userName, pwd, Collections.emptySet()));
    }

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

    @Override
    public Optional<User> findByUserName(String userName) {
        return userRepository.findByUserName(userName);
    }

}
