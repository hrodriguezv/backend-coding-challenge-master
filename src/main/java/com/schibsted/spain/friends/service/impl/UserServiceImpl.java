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
import com.schibsted.spain.friends.exception.InvalidUserNameException;
import com.schibsted.spain.friends.model.User;
import com.schibsted.spain.friends.repository.spec.IFriendShipRepository;
import com.schibsted.spain.friends.repository.spec.IUserRepository;
import com.schibsted.spain.friends.service.spec.IUserService;
import com.schibsted.spain.friends.util.AdevintaConstants;

/**
 * @author hrodriguez
 *
 */
//@Slf4j
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private IFriendShipRepository friendshipRepository;

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
    public List<User> listFriendsByUserName(String userName) throws BaseException {

        if (userName == null) {
            throw new InvalidUserNameException(AdevintaConstants.INVALID_USERNAME_NULL);
        }

        Optional<User> user = userRepository.findByUserName(userName);

        if (user.isPresent()) {

            User entity = user.get();
            return friendshipRepository.findFriendsByUserId(entity.getId());

        }

        return Collections.emptyList();
    }

}
