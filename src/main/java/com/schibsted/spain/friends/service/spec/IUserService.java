package com.schibsted.spain.friends.service.spec;

import java.util.List;
import java.util.Optional;

import com.schibsted.spain.friends.exception.BaseException;
import com.schibsted.spain.friends.model.User;

// TODO: Auto-generated Javadoc
/**
 * The Interface IUserService.
 */
public interface IUserService {

    /**
     * List friends by user name.
     *
     * @param userName the user name
     * @param pwd the pwd
     * @return the list
     * @throws BaseException the base exception
     */
    List<User> listFriendsByUserName(String userName, String pwd) throws BaseException;

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
     * @return the optional
     */
    Optional<User> findByUserName(String userName);
}
