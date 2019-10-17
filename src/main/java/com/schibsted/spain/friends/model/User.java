/**
 * 
 */
package com.schibsted.spain.friends.model;

import com.schibsted.spain.friends.validator.spec.PasswordConstraint;
import com.schibsted.spain.friends.validator.spec.UserNameConstraint;

/**
 * Data structure that reflects the characteristics of a User.
 *
 * @author hrodriguez
 */
public class User {

    /** The user name. */
    @UserNameConstraint
    private String userName;

    /** The password. */
    @PasswordConstraint
    private String password;

    /**
     * Instantiates a new user.
     *
     * @param usrName the usr name
     * @param pwd the pwd
     */
    public User(String usrName, String pwd) {
        this.userName = usrName;
        this.password = pwd;
    }

    /**
     * Gets the user name.
     *
     * @return the user name
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Sets the user name.
     *
     * @param userName the new user name
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * Gets the password.
     *
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the password.
     *
     * @param password the new password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Compare by reverse user name.
     *
     * @param lusr the lusr
     * @param rusr the rusr
     * @return the int
     */
    public static int compareByReverseUserName(User lusr, User rusr) {
        return rusr.userName.compareTo(lusr.userName);
    }

    /**
     * Hash code.
     *
     * @return the int
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((password == null) ? 0 : password.hashCode());
        result = prime * result + ((userName == null) ? 0 : userName.hashCode());
        return result;
    }

    /**
     * Equals.
     *
     * @param obj the obj
     * @return true, if successful
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof User)) {
            return false;
        }
        User other = (User) obj;
        if (password == null) {
            if (other.password != null) {
                return false;
            }
        } else if (!password.equals(other.password)) {
            return false;
        }
        if (userName == null) {
            if (other.userName != null) {
                return false;
            }
        } else if (!userName.equals(other.userName)) {
            return false;
        }
        return true;
    }

}
