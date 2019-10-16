/**
 * 
 */
package com.schibsted.spain.friends.repository;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import java.util.Collections;
import java.util.Optional;

import javax.validation.ConstraintViolationException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.schibsted.spain.friends.exception.InvalidPasswordException;
import com.schibsted.spain.friends.exception.InvalidUserNameException;
import com.schibsted.spain.friends.model.User;
import com.schibsted.spain.friends.repository.spec.UserRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryIntegrationTest {

    /** The repository. */
    @Autowired
    private UserRepository repository;

    @Test
    public void givenNewUser_whenCreate_thenOK() {
        User user = repository.save(new User("kperez", "Holamund0", Collections.emptySet()));
        assertThat(user, is(notNullValue()));
    }

    @Test(expected = InvalidPasswordException.class)
    public void givenNewUser_whenCreateInvalidPassword_thenFail() {
        repository.save(new User("dperez", "hola", Collections.emptySet()));
    }

    @Test(expected = InvalidUserNameException.class)
    public void givenNewUser_whenCreateInvalidUserName_thenFail() {
        repository.save(new User("sa", "@Holamundo1#", Collections.emptySet()));
    }

    @Test
    public void givenUser_whenFindById_thenSuccess() {
        User user = new User("pperez", "Holamund0", Collections.emptySet());
        repository.save(user);

        Optional<User> retrievedUser = repository.findByUserName(user.getUserName());

        assertThat(retrievedUser.get(), is(equalTo(user)));
    }

    @Test
    public void givenUser_whenFindByUserName_thenSuccess() {
        User user = new User("jperez", "Holamund0", Collections.emptySet());
        repository.save(user);

        Optional<User> retrievedUser = repository.findByUserName(user.getUserName());

        assertThat(retrievedUser.get(), is(equalTo(user)));
    }

    @Test(expected = ConstraintViolationException.class)
    public void given2User_whenCreateSameUserName_thenFail() {
        User user1 = new User("rperez", "Holamund0", Collections.emptySet());
        repository.save(user1);

        User user2 = new User("rperez", "mund0Hola", Collections.emptySet());
        repository.save(user2);
    }

}
