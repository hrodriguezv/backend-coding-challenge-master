/**
 * 
 */
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
 * The Class SignUpControllerIntegrationTest.
 *
 * @author hrodriguez
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class SignUpControllerIntegrationTest {

    /** The client. */
    @Autowired
    private TestRestTemplate client;

    /** The Constant RESOURCE_URL. */
    private static final String RESOURCE_URL = "/signup";

    /** The Constant USERNAME_KEY. */
    private static final String USERNAME_KEY = "username";
    
    /** The Constant SC_KEY. */
    private static final String SC_KEY = "X-Password";

    /** The headers. */
    private HttpHeaders headers;
    
    /** The body. */
    private MultiValueMap<String, String> body;
    
    /** The request. */
    private HttpEntity<MultiValueMap<String, String>> request;

    /**
     * Setup.
     */
    @Before
    public void setup() {
        headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        body = new LinkedMultiValueMap<>();
    }

    /**
     * Given user nameand pwd when sign up then success.
     */
    @Test
    public void givenUserNameandPwd_whenSignUp_thenSuccess() {

        headers.add(SC_KEY, "HolaMund0");
        body.add(USERNAME_KEY, "admin");
        request = new HttpEntity<>(body, headers);

        ResponseEntity<Void> response = client.postForEntity(RESOURCE_URL, request, Void.class);
        assertTrue(response.getStatusCode() == HttpStatus.OK);
    }

    /**
     * Given user nameand invalid format pwd when sign up then fail.
     */
    @Test
    public void givenUserNameandInvalidFormatPwd_whenSignUp_thenFail() {
        headers.add(SC_KEY, "HolaMund0!");
        body.add(USERNAME_KEY, "admin");
        request = new HttpEntity<>(body, headers);

        ResponseEntity<Void> response = client.postForEntity(RESOURCE_URL, request, Void.class);
        assertTrue(response.getStatusCode() == HttpStatus.UNPROCESSABLE_ENTITY);
    }

    /**
     * Given invalid user name when sign up then fail.
     */
    @Test
    public void givenInvalidUserName_whenSignUp_thenFail() {
        headers.add(SC_KEY, "HolaMund0");
        body.add(USERNAME_KEY, "sa");
        request = new HttpEntity<>(body, headers);

        ResponseEntity<Void> response = client.postForEntity(RESOURCE_URL, request, Void.class);
        assertTrue(response.getStatusCode() == HttpStatus.UNPROCESSABLE_ENTITY);
    }
}
