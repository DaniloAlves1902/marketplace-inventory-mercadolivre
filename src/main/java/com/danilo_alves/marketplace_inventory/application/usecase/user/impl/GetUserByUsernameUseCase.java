package com.danilo_alves.marketplace_inventory.application.usecase.user.impl;

import com.danilo_alves.marketplace_inventory.application.gateway.user.UserGateway;
import com.danilo_alves.marketplace_inventory.application.usecase.user.GetByUsername;
import com.danilo_alves.marketplace_inventory.domain.entity.user.UserDomain;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class GetUserByUsernameUseCase implements GetByUsername {
    private final UserGateway userGateway;

    @Override
    public UserDomain execute(String username) {
        return userGateway.findByUsername(username)
                .orElseThrow(() -> new IllegalArgumentException("User not found with username: " + username));
    }
}
