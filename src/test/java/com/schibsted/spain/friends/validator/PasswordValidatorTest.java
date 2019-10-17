/**
 * 
 */
package com.schibsted.spain.friends.validator;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.Before;
import org.junit.Test;

import com.schibsted.spain.friends.model.User;

// TODO: Auto-generated Javadoc
/**
 * The Class PasswordValidatorTest.
 */
public class PasswordValidatorTest {

    /** The validator. */
    private Validator validator;

    /**
     * Sets the up.
     */
    @Before
    public void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    /**
     * Given new transaction when validate against right now then success.
     */
    @Test
    public void givenNewUser_whenValidatePwd_thenSuccess() {

        User dummyUser = new User("admin", "j12345678");

        Set<ConstraintViolation<User>> violations = validator.validate(dummyUser);
        assertTrue(violations.isEmpty());

    }

    /**
     * Given new user when validate numeric pwd then success.
     */
    @Test
    public void givenNewUser_whenValidateNumericPwd_thenSuccess() {

        User dummyUser = new User("admin1", "12345678");

        Set<ConstraintViolation<User>> violations = validator.validate(dummyUser);
        assertTrue(violations.isEmpty());

    }

    /**
     * Given new user when validate invalid MIN size char user name then fail.
     */
    @Test
    public void givenNewUser_whenValidateInvalidMINSizeCharUserName_thenFail() {

        User dummyUser = new User("admin2", "1234");

        Set<ConstraintViolation<User>> violations = validator.validate(dummyUser);
        assertFalse(violations.isEmpty());

    }

    /**
     * Given new user when validate invalid MAX size char user name then fail.
     */
    @Test
    public void givenNewUser_whenValidateInvalidMAXSizeCharUserName_thenFail() {

        User dummyUser = new User("admin3", "@#FASD@#@RASD#R#ASD#");

        Set<ConstraintViolation<User>> violations = validator.validate(dummyUser);
        assertFalse(violations.isEmpty());

    }

    /**
     * Given new user when validate invalid format pwd then fail.
     */
    @Test
    public void givenNewUser_whenValidateInvalidFormatPwd_thenFail() {

        User dummyUser = new User("admin4", "j123-4");

        Set<ConstraintViolation<User>> violations = validator.validate(dummyUser);
        assertFalse(violations.isEmpty());

    }
}
