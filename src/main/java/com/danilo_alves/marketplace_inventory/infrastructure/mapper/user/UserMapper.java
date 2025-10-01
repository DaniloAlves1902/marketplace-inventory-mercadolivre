package com.danilo_alves.marketplace_inventory.infrastructure.mapper.user;

import com.danilo_alves.marketplace_inventory.domain.entity.user.UserDomain;
import com.danilo_alves.marketplace_inventory.infrastructure.persistence.entity.user.UserEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDomain toDomain(UserEntity userEntity);

    UserEntity toEntity(UserDomain userDomain);
}
