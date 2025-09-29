package com.danilo_alves.marketplace_inventory.application.usecase;

public interface UseCase<InputDTO, OutputDTO> {
    OutputDTO execute(InputDTO input);
}
