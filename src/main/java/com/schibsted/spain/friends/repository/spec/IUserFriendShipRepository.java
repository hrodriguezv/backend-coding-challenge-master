package com.schibsted.spain.friends.repository.spec;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.schibsted.spain.friends.model.Friendship;
import com.schibsted.spain.friends.model.FriendshipPK;
import com.schibsted.spain.friends.model.User;

@Repository
public interface IUserFriendShipRepository extends JpaRepository<Friendship, FriendshipPK> {

    @Query("SELECT f.pk.friend FROM Friendship f WHERE f.pk.owner.id = :id and f.status = 1")
    public List<User> findFriendsByUserId(@Param("id") Long id);

}
