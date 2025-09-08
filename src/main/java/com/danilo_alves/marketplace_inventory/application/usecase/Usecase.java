package com.danilo_alves.marketplace_inventory.application.usecase;

public interface Usecase<InputDTO, OutputDTO> {
    OutputDTO execute(InputDTO input);
}
