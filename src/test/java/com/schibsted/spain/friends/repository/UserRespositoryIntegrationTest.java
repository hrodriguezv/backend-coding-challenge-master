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
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.dao.DataIntegrityViolationException;
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
        User user = repository.save(new User("jperez", "#Holamund0", Collections.emptySet()));
        assertThat(user, is(notNullValue()));
    }

    @Test(expected = ConstraintViolationException.class)
    public void givenNewUser_whenCreateInvalidPassword_thenFail() {
        repository.save(new User("jperez", "holamundo", Collections.emptySet()));
    }

    @Test(expected = ConstraintViolationException.class)
    public void givenNewUser_whenCreateInvalidUserName_thenFail() {
        repository.save(new User("sa", "@Holamundo1#", Collections.emptySet()));
    }

    @Test
    public void givenUser_whenFindById_thenSuccess() {
        User user = new User("jperez", "#Holamund0", Collections.emptySet());
        repository.save(user);

        Optional<User> retrievedUser = repository.findById(user.getId());

        assertThat(retrievedUser.get(), is(equalTo(user)));
    }

    @Test
    public void givenUser_whenFindByUserName_thenSuccess() {
        User user = new User("jperez", "#Holamund0", Collections.emptySet());
        repository.save(user);

        Optional<User> retrievedUser = repository.findByUserName(user.getUserName());

        assertThat(retrievedUser.get(), is(equalTo(user)));
    }

    @Test(expected = DataIntegrityViolationException.class)
    public void given2User_whenCreateSameUserName_thenFail() {
        User user1 = new User("jperez", "#Holamund0", Collections.emptySet());
        repository.save(user1);

        User user2 = new User("jperez", "#mund0Hola", Collections.emptySet());
        repository.save(user2);
    }

}
