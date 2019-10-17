/**
 * 
 */
package com.schibsted.spain.friends.model;

import java.io.Serializable;

/**
 * @author hrodriguez
 *
 */
public class Friendship implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 5397498873072534679L;

    private FriendshipPK pk;

    private FriendshipStatus status;

    public Friendship(User owner, User friend, FriendshipStatus status) {
        pk = new FriendshipPK();
        pk.setOwner(owner);
        pk.setFriend(friend);
        this.status = status;
    }

    public FriendshipPK getPk() {
        return pk;
    }

    public void setPk(FriendshipPK pk) {
        this.pk = pk;
    }

    public FriendshipStatus getStatus() {
        return status;
    }

    public void setStatus(FriendshipStatus status) {
        this.status = status;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((pk == null) ? 0 : pk.hashCode());
        result = prime * result + ((status == null) ? 0 : status.hashCode());
        return result;
    }

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
        if (status != other.status) {
            return false;
        }
        return true;
    }

}
