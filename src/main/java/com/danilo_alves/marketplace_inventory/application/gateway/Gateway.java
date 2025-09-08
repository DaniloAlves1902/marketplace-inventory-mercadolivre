package com.danilo_alves.marketplace_inventory.application.gateway;

import java.util.List;

public interface Gateway<T> {
    T save(T object);

    T update(T object);

    Void delete(Long id);

    List<T> getAll();

    T getById(Long id);
}
