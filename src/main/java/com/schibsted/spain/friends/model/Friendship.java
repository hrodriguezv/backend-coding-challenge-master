/**
 * 
 */
package com.schibsted.spain.friends.model;

import java.io.Serializable;
import java.time.Instant;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author hrodriguez
 *
 */
@Entity
@Table(name = "user_friends")
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

    @EmbeddedId
    @JsonIgnore
    private UserFriendshipPK pk;

    @NotNull
    @Enumerated(EnumType.ORDINAL)
    private FriendshipStatus status;

    @NotNull
    private Instant updated;

    @Version
    private int version;
}
