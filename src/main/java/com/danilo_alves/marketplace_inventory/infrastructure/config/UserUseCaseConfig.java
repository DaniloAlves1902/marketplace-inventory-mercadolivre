package com.danilo_alves.marketplace_inventory.infrastructure.config;

import com.danilo_alves.marketplace_inventory.application.gateway.user.UserGateway;
import com.danilo_alves.marketplace_inventory.application.usecase.user.*;
import com.danilo_alves.marketplace_inventory.application.usecase.user.impl.*;
import com.danilo_alves.marketplace_inventory.infrastructure.decorator.TransactionalCreateUser;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserUseCaseConfig {
    @Bean
    public CreateUser createUser(UserGateway userGateway) {
        CreateUser useCase = new CreateUserUsecase(userGateway);
        return new TransactionalCreateUser(useCase);
    }

    @Bean
    public UpdateUser updateUser(UserGateway userGateway) {
        return new UpdateUserUseCase(userGateway);
    }

    @Bean
    public DeleteUser deleteUser(UserGateway userGateway) {
        return new DeleteUserUseCase(userGateway);
    }

    @Bean
    public GetAllUser getAllUser(UserGateway userGateway) {
        return new GetAllUsersUseCase(userGateway);
    }

    @Bean
    public GetByUsername getByUsername(UserGateway userGateway) {
        return new GetUserByUsernameUseCase(userGateway);
    }
}
