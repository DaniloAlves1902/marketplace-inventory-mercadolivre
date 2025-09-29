package com.danilo_alves.marketplace_inventory.application.usecase.user.impl;

import com.danilo_alves.marketplace_inventory.application.gateway.user.UserGateway;
import com.danilo_alves.marketplace_inventory.application.usecase.user.CreateUser;
import com.danilo_alves.marketplace_inventory.domain.entity.user.UserDomain;
import com.danilo_alves.marketplace_inventory.domain.exception.user.UserAlreadyExistsException;
import com.danilo_alves.marketplace_inventory.domain.validator.UserValidator;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CreateUserUsecase implements CreateUser {
    private final UserGateway userGateway;

    @Override
    public UserDomain execute(UserDomain userDomain) {
        UserValidator.validate(userDomain);
        if (userGateway.existsByUsername(userDomain.getUsername())) {
            throw new UserAlreadyExistsException(userDomain.getUsername());
        }

        return userGateway.save(userDomain);
    }
}
