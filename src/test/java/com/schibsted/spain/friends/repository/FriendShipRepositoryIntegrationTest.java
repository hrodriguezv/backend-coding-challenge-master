/**
 * 
 */
package com.schibsted.spain.friends.repository;

import java.util.Collections;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.schibsted.spain.friends.model.User;
import com.schibsted.spain.friends.repository.spec.IUserFriendShipRepository;
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
    private IUserFriendShipRepository friendshipRepository;

    @Test
    public void givenUsers_whenUser1RequestFriendshipUser2_thenSuccess() {
        User user1 = new User("jperez", "#Holamund0", Collections.emptyList());
        userRepository.save(user1);

        User user2 = new User("ggonzalez", "#mund0Hola", Collections.emptyList());
        userRepository.save(user2);

        // Friendship relation = new Friendship(user1.getId(), user2, FriendshipStatus.REQUESTED, Clock.systemUTC().instant());
        //
        // friendshipRepository.save(relation);
        //
        // assertThat(relation, is(notNullValue()));
    }

    @Test
    public void givenUsers_whenUser1SentRequestFriendshipUser2_thenFail() {
        User user1 = new User("jperez", "#Holamund0", Collections.emptyList());
        userRepository.save(user1);

        User user2 = new User("ggonzalez", "#mund0Hola", Collections.emptyList());
        userRepository.save(user2);

        // Friendship relation = new Friendship(user1.getId(), user2, FriendshipStatus.REQUESTED, Clock.systemUTC().instant());
        // friendshipRepository.save(relation);
        //
        // Friendship newRequest = new Friendship(user1.getId(), user2, FriendshipStatus.REQUESTED, Clock.systemUTC().instant());
        // friendshipRepository.save(newRequest);
    }

}
