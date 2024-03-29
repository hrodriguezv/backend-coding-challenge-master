/**
 * 
 */
package com.schibsted.spain.friends.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.persistence.Version;

import com.schibsted.spain.friends.validator.spec.PasswordConstraint;
import com.schibsted.spain.friends.validator.spec.UserNameConstraint;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * The Class User.
 *
 * @author hrodriguez
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "user", uniqueConstraints = { @UniqueConstraint(columnNames = { "userName" }) })
public class User {

    /** The id. */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** The user name. */
    @Column(nullable = false)
    @UserNameConstraint
    private String userName;

    /** The password. */
    @Column(nullable = false)
    @PasswordConstraint
    private String password;

    /** The friends. */
    @OneToMany(mappedBy = "pk.owner")
    private Set<Friendship> friends = new HashSet<>();
    
    /** The version. */
    @Version
    private int version;
    
    /**
     * Instantiates a new user.
     *
     * @param userName the user name
     * @param password the password
     * @param userFriends the user friends
     */
    public User(String userName, String password, Set<Friendship> userFriends) {
        super();
        this.userName = userName;
        this.password = password;
        this.friends = userFriends;
    }

    /**
     * Instantiates a new user.
     *
     * @param id the id
     * @param userName the user name
     * @param password the password
     * @param userFriends the user friends
     */
    public User(Long id, String userName, String password, Set<Friendship> userFriends) {
        super();
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.friends = userFriends;
    }

}
