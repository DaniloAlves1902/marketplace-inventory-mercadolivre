package com.danilo_alves.marketplace_inventory.presentation.controller.user;

import com.danilo_alves.marketplace_inventory.application.usecase.user.*;
import com.danilo_alves.marketplace_inventory.domain.entity.product.ProductDomain;
import com.danilo_alves.marketplace_inventory.domain.entity.user.UserDomain;
import com.danilo_alves.marketplace_inventory.presentation.dto.product.ProductRequestDTO;
import com.danilo_alves.marketplace_inventory.presentation.dto.user.UserRequestDTO;
import com.danilo_alves.marketplace_inventory.presentation.dto.user.UserResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {
    private final CreateUser createUser;
    private final UpdateUser updateUser;
    private final DeleteUser deleteUser;
    private final GetAllUser getAllUsers;
    private final GetByIdUser getByIdUser;
    private final GetByUsernameUser getByUsernameUser;

    @PostMapping
    public ResponseEntity<UserResponseDTO> create(@RequestBody UserRequestDTO dto) {
        UserDomain userToCreate = toDomain(dto);
        UserDomain createdUser = createUser.execute(userToCreate);
        UserResponseDTO response = UserResponseDTO.fromDomain(createdUser);
        return ResponseEntity.created(URI.create("/api/v1/users" + response.id())).body(response);
    }

    private UserDomain toDomain(UserRequestDTO dto) {
        return new UserDomain(
                null,
                dto.name(),
                dto.username(),
                dto.password()
        );
    }
}
