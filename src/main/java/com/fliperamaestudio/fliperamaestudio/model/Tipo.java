package com.fliperamaestudio.fliperamaestudio.model;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;


public enum Tipo implements GrantedAuthority {
    SUPER,
    ADMIN,
    CLI;

    @Override
    public String getAuthority() {
        return this.name();
    }
}