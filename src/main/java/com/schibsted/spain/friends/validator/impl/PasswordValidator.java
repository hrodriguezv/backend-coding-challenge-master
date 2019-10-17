/**
 * 
 */
package com.schibsted.spain.friends.validator.impl;

import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.schibsted.spain.friends.util.AdevintaConstants;
import com.schibsted.spain.friends.validator.spec.PasswordConstraint;

/**
 * Defines the logic to validate a given constraint on a password field used in User object.
 *
 * @author hrodriguez
 */
public class PasswordValidator implements ConstraintValidator<PasswordConstraint, String> {

    /** The pattern. */
    private Pattern pattern = Pattern.compile("[A-Za-z0-9]+");

    /**
     * Checks if is valid.
     *
     * @param pwd the pwd
     * @param context the context
     * @return true, if is valid
     */
    @Override
    public boolean isValid(String pwd, ConstraintValidatorContext context) {

        context.disableDefaultConstraintViolation();

        if (pwd == null) {
            context.buildConstraintViolationWithTemplate(AdevintaConstants.INVALID_SC_NULL)
                .addConstraintViolation();
            return false;
        }

        if (pwd.length() < AdevintaConstants.MIN_CHAR_SC || pwd.length() > AdevintaConstants.MAX_CHAR_SC) {
            context.buildConstraintViolationWithTemplate(AdevintaConstants.INVALID_SC_LENGTH)
                .addConstraintViolation();

            return false;
        }

        if (!pattern.matcher(pwd)
            .matches()) {
            context.buildConstraintViolationWithTemplate(AdevintaConstants.INVALID_SC_FORMAT)
                .addConstraintViolation();
            return false;
        }

        return true;
    }
}
