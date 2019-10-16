package com.schibsted.spain.friends.legacy;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.schibsted.spain.friends.exception.InvalidHimSelfRequestFrienshipException;
import com.schibsted.spain.friends.exception.InvalidPreviousRequestSentException;
import com.schibsted.spain.friends.exception.InvalidRequestAlreadyFriendsException;
import com.schibsted.spain.friends.exception.InvalidRequestRequiredException;
import com.schibsted.spain.friends.exception.InvalidUserDoesNotExistException;
import com.schibsted.spain.friends.exception.InvalidUserNameException;
import com.schibsted.spain.friends.model.Friendship;
import com.schibsted.spain.friends.model.FriendshipStatus;
import com.schibsted.spain.friends.model.User;
import com.schibsted.spain.friends.service.spec.IFriendshipService;
import com.schibsted.spain.friends.service.spec.IUserService;
import com.schibsted.spain.friends.util.AdevintaConstants;

@RestController
@RequestMapping("/friendship")
public class FriendshipLegacyController {

    @Autowired
    private IUserService userService;

    @Autowired
    private IFriendshipService friendShipService;

    private void checkEntryData(String usernameFrom, String usernameTo) {
        if ((usernameFrom == null) || (usernameTo == null)) {
            throw new InvalidUserNameException(AdevintaConstants.INVALID_USERNAME_NULL);
        }

        if (usernameFrom.equals(usernameTo)) {
            throw new InvalidHimSelfRequestFrienshipException(usernameFrom);
        }
    }

    @PostMapping("/request")
    void requestFriendship(@RequestParam("usernameFrom") String usernameFrom, @RequestParam("usernameTo") String usernameTo, @RequestHeader("X-Password") String password) {

        checkEntryData(usernameFrom, usernameTo);

        User userFrom = userService.findByUserName(usernameFrom)
            .orElseThrow(InvalidUserDoesNotExistException::new);
        User userTo = userService.findByUserName(usernameTo)
            .orElseThrow(InvalidUserDoesNotExistException::new);

        Optional<Friendship> previousRelation = friendShipService.findRelation(userFrom, userTo);

        if (previousRelation.isPresent()) {
            FriendshipStatus status = previousRelation.get()
                .getStatus();

            if (status.equals(FriendshipStatus.REQUESTED)) {
                throw new InvalidPreviousRequestSentException();
            } else if (status.equals(FriendshipStatus.ACCEPTED)) {
                throw new InvalidRequestAlreadyFriendsException();
            }

        }

        friendShipService.requestFriendship(userFrom, userTo);
    }

    @PostMapping("/accept")
    void acceptFriendship(@RequestParam("usernameFrom") String usernameFrom, @RequestParam("usernameTo") String usernameTo, @RequestHeader("X-Password") String password) {

        checkEntryData(usernameFrom, usernameTo);

        User userFrom = userService.findByUserName(usernameFrom)
            .orElseThrow(InvalidUserDoesNotExistException::new);
        User userTo = userService.findByUserName(usernameTo)
            .orElseThrow(InvalidUserDoesNotExistException::new);

        Optional<Friendship> previousRelation = friendShipService.findRelation(userTo, userFrom);

        if (previousRelation.isPresent()) {
            FriendshipStatus status = previousRelation.get()
                .getStatus();

            if (status.equals(FriendshipStatus.ACCEPTED)) {
                throw new InvalidRequestAlreadyFriendsException();
            } else if (status.equals(FriendshipStatus.DECLINED)) {
                throw new InvalidRequestRequiredException();
            } else if (status.equals(FriendshipStatus.REQUESTED)) {
                friendShipService.acceptFriendship(userFrom, userTo);
            }
        } else {
            throw new InvalidRequestRequiredException();
        }
    }

    @PostMapping("/decline")
    void declineFriendship(@RequestParam("usernameFrom") String usernameFrom, @RequestParam("usernameTo") String usernameTo, @RequestHeader("X-Password") String password) {
        checkEntryData(usernameFrom, usernameTo);

    }

    @GetMapping("/list")
    Object listFriends(@RequestParam("username") String username, @RequestHeader("X-Password") String password) {
        throw new RuntimeException("not implemented yet!");
    }
}
