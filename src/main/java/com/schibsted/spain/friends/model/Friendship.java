/**
 * 
 */
package com.schibsted.spain.friends.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author hrodriguez
 *
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
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

}
