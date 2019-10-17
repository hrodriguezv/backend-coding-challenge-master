/**
 * 
 */
package com.schibsted.spain.friends.model;

import java.util.HashSet;
import java.util.Set;

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

    /** The friends. */
    private Set<Friendship> friends = new HashSet<>();

    public User(String usrName, String pwd, Set<Friendship> emptySet) {
        this.userName = usrName;
        this.password = pwd;
        this.friends = emptySet;
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

    public Set<Friendship> getFriends() {
        return friends;
    }

    public void setFriends(Set<Friendship> friends) {
        this.friends = friends;
    }

    public static int compareByReverseUserName(User lusr, User rusr) {
        return rusr.userName.compareTo(lusr.userName);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((friends == null) ? 0 : friends.hashCode());
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
        if (friends == null) {
            if (other.friends != null) {
                return false;
            }
        } else if (!friends.equals(other.friends)) {
            return false;
        }
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
