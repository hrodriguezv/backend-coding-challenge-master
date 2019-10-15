/**
 * 
 */
package com.schibsted.spain.friends.repository;

import java.util.Collections;

import javax.validation.ConstraintViolationException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.schibsted.spain.friends.model.User;
import com.schibsted.spain.friends.repository.spec.IUserRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRespositoryIntegrationTest {

    /** The repository. */
    @Autowired
    private IUserRepository repository;

    @Test
    public void givenNewUser_whenCreate_thenOK() {
        repository.save(new User(1L, "jperez", "#Holamund0", Collections.emptySet()));
    }

    @Test(expected = ConstraintViolationException.class)
    public void givenNewUser_whenCreateInvalidPassword_thenFail() {
        repository.save(new User(1L, "jperez", "holamundo", Collections.emptySet()));
    }

    @Test(expected = ConstraintViolationException.class)
    public void givenNewUser_whenCreateInvalidUserName_thenFail() {
        repository.save(new User(1L, "sa", "@Holamundo1#", Collections.emptySet()));
    }

}
