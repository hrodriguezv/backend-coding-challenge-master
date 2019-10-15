/**
 * 
 */
package com.schibsted.spain.friends.validator;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Collections;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.Before;
import org.junit.Test;

import com.schibsted.spain.friends.model.User;

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

        User dummyUser = new User("admin", "#holaVale1!", Collections.emptyList());

        Set<ConstraintViolation<User>> violations = validator.validate(dummyUser);
        assertTrue(violations.isEmpty());

    }

    @Test
    public void givenNewUser_whenValidateNumericPwd_thenFail() {

        User dummyUser = new User("admin", "12345678", Collections.emptyList());

        Set<ConstraintViolation<User>> violations = validator.validate(dummyUser);
        assertTrue(!violations.isEmpty());

    }

    @Test
    public void givenNewUser_whenValidateInvalidMINSizeCharUserName_thenFail() {

        User dummyUser = new User("admin", "1234", Collections.emptyList());

        Set<ConstraintViolation<User>> violations = validator.validate(dummyUser);
        assertFalse(violations.isEmpty());

    }

    @Test
    public void givenNewUser_whenValidateInvalidMAXSizeCharUserName_thenFail() {

        User dummyUser = new User("admin", "@#FASD@#@RASD#R#ASD#", Collections.emptyList());

        Set<ConstraintViolation<User>> violations = validator.validate(dummyUser);
        assertFalse(violations.isEmpty());

    }

}
