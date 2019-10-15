package com.schibsted.spain.friends.repository.spec;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.schibsted.spain.friends.exception.BaseException;
import com.schibsted.spain.friends.exception.InvalidPasswordException;
import com.schibsted.spain.friends.exception.InvalidUserNameException;
import com.schibsted.spain.friends.model.User;
import com.schibsted.spain.friends.util.AdevintaConstants;

@Repository
public interface IUserRepository extends JpaRepository<User, Long> {

    @Query(value = "SELECT " + " COUNT(co) " + "FROM User co " + "WHERE " + "LOWER(co.userName) = ?1 ")
    Long count(String name);

    default void manageBaseException(String message) {

        switch (message) {
        case AdevintaConstants.INVALID_USERNAME_FORMAT:
        case AdevintaConstants.INVALID_USERNAME_LENGTH:
        case AdevintaConstants.INVALID_USERNAME_NULL:
            throw new InvalidUserNameException(message);
        case AdevintaConstants.INVALID_PWD_FORMAT:
        case AdevintaConstants.INVALID_PWD_LENGTH:
        case AdevintaConstants.INVALID_PWD_NULL:
            throw new InvalidPasswordException(message);
        default:
            throw new BaseException(message);
        }
    }
}
