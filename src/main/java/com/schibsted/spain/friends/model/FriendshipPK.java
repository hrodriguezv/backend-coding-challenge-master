/**
 * 
 */
package com.schibsted.spain.friends.model;

import java.io.Serializable;

/**
 * Represents primary key of friendship's store 
 *
 * @author hrodriguez
 */
public class FriendshipPK implements Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 2266577494273194416L;

    /** The owner. */
    private User owner;

    /** The friend. */
    private User friend;

    /**
     * Instantiates a new friendship PK.
     *
     * @param userFrom the user from
     * @param userTo the user to
     */
    public FriendshipPK(User userFrom, User userTo) {
        this.owner = userFrom;
        this.friend = userTo;
    }

    /**
     * Instantiates a new friendship PK.
     */
    public FriendshipPK() {
        super();
    }

    /**
     * Gets the owner.
     *
     * @return the owner
     */
    public User getOwner() {
        return owner;
    }

    /**
     * Sets the owner.
     *
     * @param owner the new owner
     */
    public void setOwner(User owner) {
        this.owner = owner;
    }

    /**
     * Gets the friend.
     *
     * @return the friend
     */
    public User getFriend() {
        return friend;
    }

    /**
     * Sets the friend.
     *
     * @param friend the new friend
     */
    public void setFriend(User friend) {
        this.friend = friend;
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
        result = prime * result + ((friend == null) ? 0 : friend.hashCode());
        result = prime * result + ((owner == null) ? 0 : owner.hashCode());
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
