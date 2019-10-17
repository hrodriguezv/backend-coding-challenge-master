/**
 * 
 */
package com.schibsted.spain.friends.model;

import java.io.Serializable;

// TODO: Auto-generated Javadoc
/**
 * The Class Friendship.
 *
 * @author hrodriguez
 */
public class Friendship implements Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 5397498873072534679L;

    /** The pk. */
    private FriendshipPK pk;

    /** The status. */
    private FriendshipStatus status;

    /**
     * Instantiates a new friendship.
     *
     * @param owner the owner
     * @param friend the friend
     * @param status the status
     */
    public Friendship(User owner, User friend, FriendshipStatus status) {
        pk = new FriendshipPK();
        pk.setOwner(owner);
        pk.setFriend(friend);
        this.status = status;
    }

    /**
     * Gets the pk.
     *
     * @return the pk
     */
    public FriendshipPK getPk() {
        return pk;
    }

    /**
     * Sets the pk.
     *
     * @param pk the new pk
     */
    public void setPk(FriendshipPK pk) {
        this.pk = pk;
    }

    /**
     * Gets the status.
     *
     * @return the status
     */
    public FriendshipStatus getStatus() {
        return status;
    }

    /**
     * Sets the status.
     *
     * @param status the new status
     */
    public void setStatus(FriendshipStatus status) {
        this.status = status;
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
        result = prime * result + ((pk == null) ? 0 : pk.hashCode());
        result = prime * result + ((status == null) ? 0 : status.hashCode());
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
        
        if (!(obj instanceof Friendship)) {
            return false;
        }
        
        Friendship other = (Friendship) obj;
        if (pk == null) {
            if (other.pk != null) {
                return false;
            }
        } else if (!pk.equals(other.pk)) {
            return false;
        }
        
        if (status != other.status) return false;
        
        return true;
    }

}
