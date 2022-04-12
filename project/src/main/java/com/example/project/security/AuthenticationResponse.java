package com.example.project.security;

import com.example.project.appuser.AppUserRole;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public class AuthenticationResponse {

    private final String jwt;
    private final Long id;
    private final Collection<? extends GrantedAuthority> role;


    public AuthenticationResponse(String jwt, Collection<? extends GrantedAuthority> role, Long id) {
        this.jwt = jwt;
        this.role = role;
        this.id = id;
    }

    public String getJwt() {
        return jwt;
    }

    public Collection<? extends GrantedAuthority> getRole() {
        return role;
    }

    public Long getId() {
        return id;
    }
}
