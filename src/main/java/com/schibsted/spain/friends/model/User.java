/**
 * 
 */
package com.schibsted.spain.friends.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.schibsted.spain.friends.validator.spec.PasswordConstraint;
import com.schibsted.spain.friends.validator.spec.UserNameConstraint;

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
@Table(name = "user")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @UserNameConstraint
    private String userName;

    @Column(nullable = false)
    @PasswordConstraint
    private String password;

    @ManyToMany
    @JoinTable(name = "user_friends", joinColumns = @JoinColumn(name = "userId"), inverseJoinColumns = @JoinColumn(name = "friendId"))
    private Set<User> userFriends;

}
