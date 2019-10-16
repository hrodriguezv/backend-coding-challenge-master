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
public class FriendshipPK implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 2266577494273194416L;

    private User owner;

    private User friend;

}
