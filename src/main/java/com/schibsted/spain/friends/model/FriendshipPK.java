/**
 * 
 */
package com.schibsted.spain.friends.model;

import java.io.Serializable;

/**
 * @author hrodriguez
 *
 */
public class FriendshipPK implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 2266577494273194416L;

    private User owner;

    private User friend;

    public FriendshipPK(User userFrom, User userTo) {
        this.owner = userFrom;
        this.friend = userTo;
    }

    public FriendshipPK() {
        super();
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public User getFriend() {
        return friend;
    }

    public void setFriend(User friend) {
        this.friend = friend;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((friend == null) ? 0 : friend.hashCode());
        result = prime * result + ((owner == null) ? 0 : owner.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FriendshipPK)) {
            return false;
        }
        FriendshipPK other = (FriendshipPK) obj;
        if (friend == null) {
            if (other.friend != null) {
                return false;
            }
        } else if (!friend.equals(other.friend)) {
            return false;
        }
        if (owner == null) {
            if (other.owner != null) {
                return false;
            }
        } else if (!owner.equals(other.owner)) {
            return false;
        }
        return true;
    }
}
