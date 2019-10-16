/**
 * 
 */
package com.schibsted.spain.friends.model;

import java.util.HashSet;
import java.util.Set;

import com.schibsted.spain.friends.validator.spec.PasswordConstraint;
import com.schibsted.spain.friends.validator.spec.UserNameConstraint;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * The Class User.
 *
 * @author hrodriguez
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class User {

    /** The user name. */
    @UserNameConstraint
    private String userName;

    /** The password. */
    @PasswordConstraint
    private String password;

    /** The friends. */
    private Set<Friendship> friends = new HashSet<>();

}
