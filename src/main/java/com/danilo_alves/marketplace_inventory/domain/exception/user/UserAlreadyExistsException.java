package com.danilo_alves.marketplace_inventory.domain.exception.user;

public class UserAlreadyExistsException extends RuntimeException {
  public UserAlreadyExistsException(String username) {
    super("User with username: " + username + " already exists.");
  }
}
