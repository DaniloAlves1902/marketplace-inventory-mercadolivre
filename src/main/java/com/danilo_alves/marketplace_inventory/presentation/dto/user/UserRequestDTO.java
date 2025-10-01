package com.danilo_alves.marketplace_inventory.presentation.dto.user;

public record UserRequestDTO(
        String id,
        String name,
        String username,
        String password
) {
}
