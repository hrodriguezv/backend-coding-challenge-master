/**
 * 
 */
package com.schibsted.spain.friends.service;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.junit.Assert.assertThat;

import java.util.List;
import java.util.stream.Collectors;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.schibsted.spain.friends.exception.InvalidRequestAlreadyFriendsException;
import com.schibsted.spain.friends.model.User;
import com.schibsted.spain.friends.service.spec.FriendshipService;
import com.schibsted.spain.friends.service.spec.UserService;

/**
 * @author hrodriguez
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class FriendshipServiceIntegrationTest {

    /** The service. */
    @Autowired
    private FriendshipService friendshipService;

    /** The user repository. */
    @Autowired
    private UserService userService;

    @Test
    public void givenUsers_whenUser1RequestFriendshipUser2_thenSuccess() {
        User user1 = userService.signUp("jperez", "Holamund0");

        User user2 = userService.signUp("ggonzalez", "mund0Hola");

        friendshipService.requestFriendship(user1.getUserName(), user2.getUserName(), "Holamundo0");
    }

    /**
     * Given users when accepted friendship then OK.
     */
    @Test
    public void givenUsers_whenAcceptedFriendship_thenOK() {

        friendshipService.acceptFriendship("ggonzalez", "jperez", "mund0Hola");

        List<String> friends = userService.listFriendsByUserName("ggonzalez", "mund0Hola")
            .stream()
            .map(User::getUserName)
            .collect(Collectors.toList());

        assertThat(friends, hasItem("jperez"));
    }

    @Test(expected = InvalidRequestAlreadyFriendsException.class)
    public void givenAlreadyFriendsUsers_whenAcceptedFriendship_thenFail() {

        friendshipService.acceptFriendship("ggonzalez", "jperez", "mund0Hola");

        userService.listFriendsByUserName("ggonzalez", "mund0Hola")
            .stream()
            .map(User::getUserName)
            .collect(Collectors.toList());
    }

}
