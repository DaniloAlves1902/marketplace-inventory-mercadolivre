package com.danilo_alves.marketplace_inventory.infrastructure.decorator;

import com.danilo_alves.marketplace_inventory.application.usecase.user.CreateUser;
import com.danilo_alves.marketplace_inventory.domain.entity.user.UserDomain;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
public class TransactionalCreateUser implements CreateUser {

    private final CreateUser decorated;

    @Override
    @Transactional
    public UserDomain execute(UserDomain userDomain) {
        return decorated.execute(userDomain);
    }
}
