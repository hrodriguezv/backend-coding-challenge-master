/**
 * 
 */
package com.schibsted.spain.friends.repository;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.schibsted.spain.friends.model.Friendship;
import com.schibsted.spain.friends.model.FriendshipPK;
import com.schibsted.spain.friends.model.FriendshipStatus;
import com.schibsted.spain.friends.model.User;
import com.schibsted.spain.friends.repository.spec.FriendShipRepository;
import com.schibsted.spain.friends.repository.spec.UserRepository;

// TODO: Auto-generated Javadoc
/**
 * The Class FriendShipRepositoryIntegrationTest.
 *
 * @author hrodriguez
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class FriendShipRepositoryIntegrationTest {

    /** The user repository. */
    @Autowired
    private UserRepository userRepository;

    /** The friendship repository. */
    @Autowired
    private FriendShipRepository friendshipRepository;

    /**
     * Given users when user 1 request friendship user 2 then success.
     */
    @Test
    public void givenUsers_whenUser1RequestFriendshipUser2_thenSuccess() {
        User user1 = new User("jperez", "Holamund0");
        userRepository.save(user1);

        User user2 = new User("ggonzalez", "mund0Hola");
        userRepository.save(user2);

        Friendship relation = friendshipRepository.save(new Friendship(user1, user2, FriendshipStatus.REQUESTED));

        assertThat(relation, is(notNullValue()));
    }

    /**
     * Given users when user 1 sent request friendship user 2 then OK.
     */
    @Test
    public void givenUsers_whenUser1SentRequestFriendshipUser2_thenOK() {
        User user1 = new User("hperez", "Holamund1");
        userRepository.save(user1);

        User user2 = new User("ogonzalez", "mund1Hola");
        userRepository.save(user2);

        Friendship relation = new Friendship(user1, user2, FriendshipStatus.REQUESTED);
        friendshipRepository.save(relation);

        Optional<Friendship> previousRequest = friendshipRepository.findById(new FriendshipPK(user1, user2));

        previousRequest.ifPresent(friendship -> assertThat(friendship.getStatus(), is(FriendshipStatus.REQUESTED)));
    }

    /**
     * Given users when accepted friendship then OK.
     */
    @Test
    public void givenUsers_whenAcceptedFriendship_thenOK() {
        User user1 = new User("pperez", "Holamund2");
        userRepository.save(user1);

        User user2 = new User("ygonzalez", "mund2Hola");
        userRepository.save(user2);

        Friendship relation = new Friendship(user1, user2, FriendshipStatus.ACCEPTED);
        friendshipRepository.save(relation);

        List<User> friends = friendshipRepository.findFriendsByUserName(user1.getUserName());

        assertThat(friends, hasItem(user2));
    }
}
