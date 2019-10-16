/**
 * 
 */
package com.schibsted.spain.friends.service;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.schibsted.spain.friends.exception.InvalidPasswordException;
import com.schibsted.spain.friends.exception.InvalidUserNameException;
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
        User user = service.signUp("jperez", "Holamund0");
        assertThat(user, is(notNullValue()));
    }

    @Test(expected = InvalidPasswordException.class)
    public void givenNewUser_whenSignUpUsingInvalidPassword_thenFail() {
        service.signUp("jperez", "hol#amundo");
    }

    @Test(expected = InvalidUserNameException.class)
    public void givenNewUser_whenSignUpUsingInvalidUserName_thenFail() {
        service.signUp("sa", "@Holamundo1#");
    }

}
