/**
 * 
 */
package com.schibsted.spain.friends.model;

import com.schibsted.spain.friends.validator.spec.PasswordConstraint;
import com.schibsted.spain.friends.validator.spec.UserNameConstraint;

/**
 * The Class User.
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

    public User(String usrName, String pwd) {
        this.userName = usrName;
        this.password = pwd;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static int compareByReverseUserName(User lusr, User rusr) {
        return rusr.userName.compareTo(lusr.userName);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((password == null) ? 0 : password.hashCode());
        result = prime * result + ((userName == null) ? 0 : userName.hashCode());
        return result;
    }

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
