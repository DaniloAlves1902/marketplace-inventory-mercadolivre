package com.danilo_alves.marketplace_inventory.domain.entity.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDomain {
    private String id;
    private String name;
    private String username;
    private String password;
}