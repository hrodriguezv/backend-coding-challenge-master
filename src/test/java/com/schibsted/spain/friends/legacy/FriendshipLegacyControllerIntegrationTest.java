package com.schibsted.spain.friends.legacy;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

/**
 * The Class FriendshipLegacyControllerIntegrationTest.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class FriendshipLegacyControllerIntegrationTest {

    /** The client. */
    @Autowired
    private TestRestTemplate client;

    /** The Constant RESOURCE_SIGNUP_URL. */
    private static final String RESOURCE_SIGNUP_URL = "/signup";

    /** The Constant RESOURCE_FRIENDSHIP_URL. */
    private static final String RESOURCE_FRIENDSHIP_URL = "/friendship";

    /** The Constant USERNAME_KEY. */
    private static final String USERNAME_KEY = "username";

    /** The Constant USERNAME_FROM_KEY. */
    private static final String USERNAME_FROM_KEY = "usernameFrom";
    
    /** The Constant USERNAME_TO_KEY. */
    private static final String USERNAME_TO_KEY = "usernameTo";
    
    /** The Constant SC_KEY. */
    private static final String SC_KEY = "X-Password";

    /** The headers. */
    private HttpHeaders headers;
    
    /** The body. */
    private MultiValueMap<String, String> body;
    
    /** The request. */
    private HttpEntity<MultiValueMap<String, String>> request;

    /**
     * Signup.
     */
    private void setUp() {
        signUp("johndoe", "j12345678");
        signUp("robert", "r0123456");
    }

    /**
     * Sign up.
     *
     * @param usr the usr
     * @param pwd the pwd
     */
    private void signUp(String usr, String pwd) {
        init();
        headers.add(SC_KEY, pwd);
        body.add(USERNAME_KEY, usr);
        request = new HttpEntity<>(body, headers);

        client.postForEntity(RESOURCE_SIGNUP_URL, request, Void.class);
    }

    /**
     * Inits the.
     */
    @Before
    public void init() {
        headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        body = new LinkedMultiValueMap<>();
    }
    

    
    /**
     * Given users when user 1 request friendship user 2 then success.
     */
    @Test
    public void givenUsers_whenUser1RequestFriendshipUser2_thenSuccess() {
        setUp();
        init();
        headers.add(SC_KEY, "j12345678");
        body.add(USERNAME_FROM_KEY, "johndoe");
        body.add(USERNAME_TO_KEY, "robert");
        request = new HttpEntity<>(body, headers);

        ResponseEntity<Void> response = client.postForEntity(RESOURCE_FRIENDSHIP_URL+"/request", request, Void.class);
        assertTrue(response.getStatusCode() == HttpStatus.OK);
    }

    /**
     * Given users when user 2 accept friendship user 1 then success.
     */
    @Test
    public void givenUsers_whenUser2AcceptFriendshipUser1_thenSuccess() {

        headers.add(SC_KEY, "r0123456");
        body.add(USERNAME_FROM_KEY, "robert");
        body.add(USERNAME_TO_KEY, "johndoe");
        request = new HttpEntity<>(body, headers);

        ResponseEntity<Void> response = client.postForEntity(RESOURCE_FRIENDSHIP_URL+"/accept", request, Void.class);
        assertTrue(response.getStatusCode() == HttpStatus.OK);
    }
    
}
