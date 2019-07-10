package com.fliperamaestudio.fliperamaestudio.model;

import org.springframework.security.core.GrantedAuthority;


public enum Tipo implements GrantedAuthority {
    SUPER,
    FUNC,
    CLI;

    @Override
    public String getAuthority() {
        return this.name();
    }
}