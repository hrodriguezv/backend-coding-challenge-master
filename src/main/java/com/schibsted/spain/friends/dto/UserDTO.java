/**
 * 
 */
package com.schibsted.spain.friends.dto;

import java.util.List;

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
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class UserDTO {

    @JsonIgnore
    private String id;
    private String userName;
    @JsonIgnore
    private String pwd;
    @JsonIgnore
    private List<UserDTO> friends;

}
