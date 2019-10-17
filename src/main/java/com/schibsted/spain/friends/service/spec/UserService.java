package com.schibsted.spain.friends.service.spec;

import java.util.List;
import java.util.Optional;

import com.schibsted.spain.friends.exception.BaseException;
import com.schibsted.spain.friends.model.User;

/**
 * Defines the operations that should be supported to store/obtain Users.
 * The implementation of this contract belongs to the service layer of this solution.
 * 
 * @author hrodriguez
 */
public interface UserService {

    /**
     * List friends by user name.
     *
     * @param userName the user name
     * @param headerAuth the header auth
     * @return the list
     * @throws BaseException the base exception
     */
    List<User> listFriendsByUserName(String userName, String headerAuth) throws BaseException;

    /**
     * Sign up.
     *
     * @param userName the user name
     * @param pwd the pwd
     * @return the user
     * @throws BaseException the base exception
     */
    User signUp(String userName, String pwd) throws BaseException;

    /**
     * Find by user name.
     *
     * @param userName the user name
     * @param headerAuth the header auth
     * @return the optional
     */
    Optional<User> findByUserName(String userName, String headerAuth);
}
