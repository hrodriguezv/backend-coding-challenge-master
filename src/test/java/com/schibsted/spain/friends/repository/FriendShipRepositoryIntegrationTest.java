/**
 * 
 */
package com.schibsted.spain.friends.repository;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.schibsted.spain.friends.model.Friendship;
import com.schibsted.spain.friends.model.FriendshipPK;
import com.schibsted.spain.friends.model.FriendshipStatus;
import com.schibsted.spain.friends.model.User;
import com.schibsted.spain.friends.repository.spec.IFriendShipRepository;
import com.schibsted.spain.friends.repository.spec.IUserRepository;

/**
 * @author hrodriguez
 *
 */
@RunWith(SpringRunner.class)
@DataJpaTest
public class FriendShipRepositoryIntegrationTest {

    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private IFriendShipRepository friendshipRepository;

    @Test
    public void givenUsers_whenUser1RequestFriendshipUser2_thenSuccess() {
        User user1 = new User("jperez", "#Holamund0", Collections.emptySet());
        userRepository.save(user1);

        User user2 = new User("ggonzalez", "#mund0Hola", Collections.emptySet());
        userRepository.save(user2);

        Friendship relation = friendshipRepository.save(new Friendship(user1, user2, FriendshipStatus.REQUESTED));

        assertThat(relation, is(notNullValue()));
    }

    @Test
    public void givenUsers_whenUser1SentRequestFriendshipUser2_thenOK() {
        User user1 = new User("jperez", "#Holamund0", Collections.emptySet());
        userRepository.save(user1);

        User user2 = new User("ggonzalez", "#mund0Hola", Collections.emptySet());
        userRepository.save(user2);

        Friendship relation = new Friendship(user1, user2, FriendshipStatus.REQUESTED);
        friendshipRepository.save(relation);

        Optional<Friendship> previousRequest = friendshipRepository.findById(new FriendshipPK(user1, user2));

        assertThat(previousRequest.get()
            .getStatus(), is(FriendshipStatus.REQUESTED));
    }

    @Test
    public void givenUsers_whenAcceptedFriendship_thenOK() {
        User user1 = new User("jperez", "#Holamund0", Collections.emptySet());
        userRepository.save(user1);

        User user2 = new User("ggonzalez", "#mund0Hola", Collections.emptySet());
        userRepository.save(user2);

        Friendship relation = new Friendship(user1, user2, FriendshipStatus.ACCEPTED);
        friendshipRepository.save(relation);
                
        List<User> friends = friendshipRepository.findFriendsByUserId(user1.getId());

        assertThat(friends, hasItem(user2));
    }
}
