package com.schibsted.spain.friends.legacy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.schibsted.spain.friends.service.spec.IUserService;

@RestController
@RequestMapping("/signup")
public class SignupLegacyController {

    @Autowired
    private IUserService userService;

    @PostMapping
    void signUp(@RequestParam("username") String username, @RequestHeader("X-Password") String password) {
        userService.signUp(username, password);
    }
}
