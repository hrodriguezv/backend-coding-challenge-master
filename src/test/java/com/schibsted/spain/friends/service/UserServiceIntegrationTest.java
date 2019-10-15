/**
 * 
 */
package com.schibsted.spain.friends.service;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import javax.validation.ConstraintViolationException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.schibsted.spain.friends.model.User;
import com.schibsted.spain.friends.service.spec.IUserService;

/**
 * @author hrodriguez
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceIntegrationTest {

    @Autowired
    private IUserService service;

    @Test
    public void givenNewUser_whenSignUpUsingCorrectValues_thenOK() {
        User user = service.signUp("jperez", "#Holamund0");
        assertThat(user, is(notNullValue()));
    }

    @Test(expected = ConstraintViolationException.class)
    public void givenNewUser_whenSignUpUsingInvalidPassword_thenFail() {
        service.signUp("jperez", "holamundo");
    }

    @Test(expected = ConstraintViolationException.class)
    public void givenNewUser_whenSignUpUsingInvalidUserName_thenFail() {
        service.signUp("sa", "@Holamundo1#");
    }

}
