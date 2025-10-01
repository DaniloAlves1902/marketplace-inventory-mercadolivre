package com.danilo_alves.marketplace_inventory.presentation.dto.user;

import com.danilo_alves.marketplace_inventory.domain.entity.user.UserDomain;

import java.util.List;
import java.util.stream.Collectors;

public record UserResponseDTO(
        String id,
        String name,
        String username,
        String password
) {

    public static UserResponseDTO fromDomain(UserDomain domain) {
        return new UserResponseDTO(
                domain.getId(),
                domain.getName(),
                domain.getUsername(),
                domain.getPassword()
        );
    }

    public static List<UserResponseDTO> fromDomain(List<UserDomain> domains) {
        return domains.stream()
                .map(UserResponseDTO::fromDomain)
                .collect(Collectors.toList());
    }
}
