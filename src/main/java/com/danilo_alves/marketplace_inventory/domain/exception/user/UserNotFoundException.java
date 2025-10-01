package com.danilo_alves.marketplace_inventory.domain.exception.user;

public class UserNotFoundException extends RuntimeException {
  public UserNotFoundException(String id) {
    super("User not found with id: " + id);
  }
}
