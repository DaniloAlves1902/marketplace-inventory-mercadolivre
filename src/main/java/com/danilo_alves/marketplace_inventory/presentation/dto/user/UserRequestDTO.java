package com.danilo_alves.marketplace_inventory.presentation.dto.user;

import com.danilo_alves.marketplace_inventory.domain.entity.user.enums.RoleDomain;

public record UserRequestDTO(
        String id,
        String name,
        String username,
        String password,
        RoleDomain role
) {
}
