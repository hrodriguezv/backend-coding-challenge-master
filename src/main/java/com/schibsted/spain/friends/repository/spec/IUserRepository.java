package com.schibsted.spain.friends.repository.spec;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.schibsted.spain.friends.model.User;

@Repository
public interface IUserRepository extends JpaRepository<User, Long> {

    @Query(value = "SELECT " + " COUNT(co) " + "FROM User co " + "WHERE " + "LOWER(co.userName) = ?1 ")
    Long count(String name);

    Optional<User> findByUserName(String userName);

    @Query("SELECT u FROM User u JOIN FETCH u.friends friends WHERE u.id = :id and friends.status = 1")
    public User findByIdAndFetchFriends(@Param("id") Long id);
}
