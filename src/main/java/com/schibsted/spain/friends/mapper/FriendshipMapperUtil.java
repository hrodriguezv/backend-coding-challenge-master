package com.schibsted.spain.friends.mapper;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.schibsted.spain.friends.dto.UserDTO;
import com.schibsted.spain.friends.model.Friendship;

/**
 * The Class FriendshipMapperUtil.
 */
public class FriendshipMapperUtil {

    /**
     * Instantiates a new friendship mapper util.
     */
    private FriendshipMapperUtil() {
    }

    /**
     * Builds the DTO from.
     *
     * @param relations the relations
     * @return the list
     */
    public static List<UserDTO> buildDTOFrom(Set<Friendship> relations) {
        return relations.stream()
            .map(UserMapperUtil::buildDTOFrom)
            .collect(Collectors.toList());
    }

    /**
     * Builds the entity from.
     *
     * @param dtos the dtos
     * @param owner the owner
     * @return the sets the
     */
    public static Set<Friendship> buildEntityFrom(List<UserDTO> dtos, UserDTO owner) {
        return dtos.stream()
            .map(dto -> UserMapperUtil.buildEntityFrom(owner, dto))
            .collect(Collectors.toSet());
    }

}
