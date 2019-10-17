package com.schibsted.spain.friends.legacy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.schibsted.spain.friends.service.spec.IUserService;

// TODO: Auto-generated Javadoc
/**
 * The Class SignupLegacyController.
 */
@RestController
@RequestMapping("/signup")
public class SignupLegacyController {

    /** The user service. */
    @Autowired
    private IUserService userService;

    /**
     * Sign up.
     *
     * @param username the username
     * @param password the password
     */
    @PostMapping
    void signUp(@RequestParam("username") String username, @RequestHeader("X-Password") String password) {
        userService.signUp(username, password);
    }
}
