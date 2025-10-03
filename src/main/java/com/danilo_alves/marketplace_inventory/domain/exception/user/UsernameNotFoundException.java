package com.danilo_alves.marketplace_inventory.domain.exception.user;

public class UsernameNotFoundException extends RuntimeException {
    public UsernameNotFoundException(String username) {
        super("Username not found: " + username);
    }
}
