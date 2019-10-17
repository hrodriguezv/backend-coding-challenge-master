package com.schibsted.spain.friends.legacy;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.schibsted.spain.friends.exception.InvalidHimSelfRequestFriendshipException;
import com.schibsted.spain.friends.exception.InvalidUserNameException;
import com.schibsted.spain.friends.model.User;
import com.schibsted.spain.friends.service.spec.FriendshipService;
import com.schibsted.spain.friends.service.spec.UserService;
import com.schibsted.spain.friends.util.AdevintaConstants;

/**
 * The Class FriendshipLegacyController.
 */
@RestController
@RequestMapping("/friendship")
public class FriendshipLegacyController {

    /** The user service. */
    @Autowired
    private UserService userService;

    /** The friend ship service. */
    @Autowired
    private FriendshipService friendShipService;

    /**
     * Check entry data.
     *
     * @param usernameFrom the username from
     * @param usernameTo the username to
     */
    private void checkEntryData(String usernameFrom, String usernameTo) {
        if ((usernameFrom == null) || (usernameTo == null)) {
            throw new InvalidUserNameException(AdevintaConstants.INVALID_USERNAME_NULL);
        }

        if (usernameFrom.equals(usernameTo)) {
            throw new InvalidHimSelfRequestFriendshipException(usernameFrom);
        }
    }

    /**
     * Request friendship.
     *
     * @param usernameFrom the username from
     * @param usernameTo the username to
     * @param password the password
     */
    @PostMapping("/request")
    void requestFriendship(@RequestParam("usernameFrom") String usernameFrom, @RequestParam("usernameTo") String usernameTo, @RequestHeader("X-Password") String password) {

        checkEntryData(usernameFrom, usernameTo);
        friendShipService.requestFriendship(usernameFrom, usernameTo, password);

    }

    /**
     * Accept friendship.
     *
     * @param usernameFrom the username from
     * @param usernameTo the username to
     * @param password the password
     */
    @PostMapping("/accept")
    void acceptFriendship(@RequestParam("usernameFrom") String usernameFrom, @RequestParam("usernameTo") String usernameTo, @RequestHeader("X-Password") String password) {

        checkEntryData(usernameFrom, usernameTo);
        friendShipService.acceptFriendship(usernameFrom, usernameTo, password);

    }

    /**
     * Decline friendship.
     *
     * @param usernameFrom the username from
     * @param usernameTo the username to
     * @param password the password
     */
    @PostMapping("/decline")
    void declineFriendship(@RequestParam("usernameFrom") String usernameFrom, @RequestParam("usernameTo") String usernameTo, @RequestHeader("X-Password") String password) {

        checkEntryData(usernameFrom, usernameTo);
        friendShipService.declineFriendship(usernameFrom, usernameTo, password);

    }

    /**
     * List friends.
     *
     * @param username the username
     * @param password the password
     * @return the object
     */
    @GetMapping("/list")
    Object listFriends(@RequestParam("username") String username, @RequestHeader("X-Password") String password) {
        return userService.listFriendsByUserName(username, password)
            .stream()
            .map(User::getUserName)
            .collect(Collectors.toList());
    }

}
