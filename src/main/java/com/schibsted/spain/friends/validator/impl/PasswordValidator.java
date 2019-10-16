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
 * @author hrodriguez
 *
 */
public class PasswordValidator implements ConstraintValidator<PasswordConstraint, String> {

    private Pattern pattern = Pattern.compile("[A-Za-z0-9]+");

    @Override
    public boolean isValid(String pwd, ConstraintValidatorContext context) {

        context.disableDefaultConstraintViolation();

        if (pwd == null) {
            context.buildConstraintViolationWithTemplate(AdevintaConstants.INVALID_PWD_NULL)
                .addConstraintViolation();
            return false;
        }

        if (pwd.length() < AdevintaConstants.MIN_CHAR_PWD || pwd.length() > AdevintaConstants.MAX_CHAR_PWD) {
            context.buildConstraintViolationWithTemplate(AdevintaConstants.INVALID_PWD_LENGTH)
                .addConstraintViolation();

            return false;
        }

        if (!pattern.matcher(pwd)
            .matches()) {
            context.buildConstraintViolationWithTemplate(AdevintaConstants.INVALID_PWD_FORMAT)
                .addConstraintViolation();
            return false;
        }

        return true;
    }
}
