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
 * @author hrodriguez
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class SignUpControllerIntegrationTest {

    /** The client. */
    @Autowired
    private TestRestTemplate client;

    /** The Constant RESOURCE_URL. */
    private static final String RESOURCE_URL = "/signup";

    private HttpHeaders headers;
    private MultiValueMap<String, String> body;
    private HttpEntity<MultiValueMap<String, String>> request;

    @Before
    public void setup() {
        headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        body = new LinkedMultiValueMap<String, String>();
    }

    @Test
    public void givenUserNameandPwd_whenSignUp_thenSuccess() {

        headers.add("X-Password", "HolaMund0");
        body.add("username", "admin");
        request = new HttpEntity<MultiValueMap<String, String>>(body, headers);

        ResponseEntity<Void> response = client.postForEntity(RESOURCE_URL, request, Void.class);
        assertTrue(response.getStatusCode() == HttpStatus.OK);
    }

    @Test
    public void givenUserNameandInvalidFormatPwd_whenSignUp_thenFail() {
        headers.add("X-Password", "HolaMund0!");
        body.add("username", "admin");
        request = new HttpEntity<MultiValueMap<String, String>>(body, headers);

        ResponseEntity<Void> response = client.postForEntity(RESOURCE_URL, request, Void.class);
        assertTrue(response.getStatusCode() == HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @Test
    public void givenInvalidUserName_whenSignUp_thenFail() {
        headers.add("X-Password", "HolaMund0");
        body.add("username", "sa");
        request = new HttpEntity<MultiValueMap<String, String>>(body, headers);

        ResponseEntity<Void> response = client.postForEntity(RESOURCE_URL, request, Void.class);
        assertTrue(response.getStatusCode() == HttpStatus.UNPROCESSABLE_ENTITY);
    }
}
