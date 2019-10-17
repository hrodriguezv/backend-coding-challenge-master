/**
 * 
 */
package com.schibsted.spain.friends.validator.impl;

import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.schibsted.spain.friends.util.AdevintaConstants;
import com.schibsted.spain.friends.validator.spec.UserNameConstraint;

// TODO: Auto-generated Javadoc
/**
 * The Class UserNameValidator.
 *
 * @author hrodriguez
 */
public class UserNameValidator implements ConstraintValidator<UserNameConstraint, String> {

    /** The pattern. */
    private Pattern pattern = Pattern.compile("[A-Za-z0-9]+");

    /**
     * Checks if is valid.
     *
     * @param userName the user name
     * @param context the context
     * @return true, if is valid
     */
    @Override
    public boolean isValid(String userName, ConstraintValidatorContext context) {

        context.disableDefaultConstraintViolation();

        if (userName == null) {
            context.buildConstraintViolationWithTemplate(AdevintaConstants.INVALID_USERNAME_NULL)
                .addConstraintViolation();
            return false;
        }

        if (userName.length() < AdevintaConstants.MIN_CHAR_USERNAME || userName.length() > AdevintaConstants.MAX_CHAR_USERNAME) {
            context.buildConstraintViolationWithTemplate(AdevintaConstants.INVALID_USERNAME_LENGTH)
                .addConstraintViolation();

            return false;
        }

        if (!pattern.matcher(userName)
            .matches()) {
            context.buildConstraintViolationWithTemplate(AdevintaConstants.INVALID_USERNAME_FORMAT)
                .addConstraintViolation();
            return false;
        }

        return true;
    }
}
