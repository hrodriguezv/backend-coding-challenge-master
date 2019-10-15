/**
 * 
 */
package com.schibsted.spain.friends.model;

import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
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
@EqualsAndHashCode
public class Friendship {

    @Id
    @Column
    private Long friendId;

    @ManyToOne
    @JoinColumn(name = "userId", nullable = false)
    private User user;

    @NotNull
    private FriendshipStatus status;

    @NotNull
    private Instant updated;

}
