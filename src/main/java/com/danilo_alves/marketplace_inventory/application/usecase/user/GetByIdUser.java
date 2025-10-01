package com.danilo_alves.marketplace_inventory.application.usecase.user;

import com.danilo_alves.marketplace_inventory.application.usecase.UseCase;
import com.danilo_alves.marketplace_inventory.domain.entity.user.UserDomain;

public interface GetByIdUser extends UseCase<String, UserDomain> {
}
