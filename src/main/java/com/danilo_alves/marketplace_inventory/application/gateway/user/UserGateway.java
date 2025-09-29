package com.danilo_alves.marketplace_inventory.application.gateway.user;

import com.danilo_alves.marketplace_inventory.application.gateway.Gateway;
import com.danilo_alves.marketplace_inventory.domain.entity.user.UserDomain;

import java.util.Optional;

public interface UserGateway extends Gateway<UserDomain, String> {
    boolean existsByUsername (String username);
    Optional<UserDomain> findByUsername(String username);
}
