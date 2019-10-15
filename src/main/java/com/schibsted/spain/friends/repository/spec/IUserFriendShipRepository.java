package com.schibsted.spain.friends.repository.spec;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.schibsted.spain.friends.model.Friendship;

@Repository
public interface IUserFriendShipRepository extends JpaRepository<Friendship, Long> {

}
