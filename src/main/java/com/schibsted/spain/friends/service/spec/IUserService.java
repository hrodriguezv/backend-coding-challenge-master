package com.schibsted.spain.friends.service.spec;

import java.util.List;
import java.util.Optional;

import com.schibsted.spain.friends.exception.BaseException;
import com.schibsted.spain.friends.model.User;

public interface IUserService {

    List<User> listFriendsByUserName(String userName) throws BaseException;

    User signUp(String userName, String pwd) throws BaseException;
    
    Optional<User> findByUserName(String userName);
}
