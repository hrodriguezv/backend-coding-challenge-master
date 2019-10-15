package com.schibsted.spain.friends.mapper;

import com.schibsted.spain.friends.dto.UserDTO;
import com.schibsted.spain.friends.model.User;

/**
 * The Class UserMapperUtil.
 */
public class UserMapperUtil {
    
    /**
     * Instantiates a new user mapper util.
     */
    private UserMapperUtil() {
    }

    /**
     * Builds the DTO from.
     *
     * @param user the user
     * @return the user DTO
     */
    public static UserDTO buildDTOFrom(User user) {
        return new UserDTO(String.valueOf(user.getId()), user.getUserName(), user.getPassword(), FriendshipMapperUtil.buildDTOFrom(user.getFriends()));
    }

    /**
     * Builds the entity from.
     *
     * @param dto the dto
     * @return the user
     */
    public static User buildEntityFrom(UserDTO dto) {
        return new User(Long.valueOf(dto.getId()), dto.getUserName(), dto.getPwd(), FriendshipMapperUtil.buildEntityFrom(dto.getFriends(), dto));
    }

}
