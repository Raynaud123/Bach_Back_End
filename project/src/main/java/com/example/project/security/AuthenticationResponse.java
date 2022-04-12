package com.example.project.security;

import com.example.project.appuser.AppUserRole;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public class AuthenticationResponse {

    private final String jwt;
    private final Collection<? extends GrantedAuthority> role;


    public AuthenticationResponse(String jwt, Collection<? extends GrantedAuthority> role) {
        this.jwt = jwt;
        this.role = role;
    }

    public String getJwt() {
        return jwt;
    }

    public Collection<? extends GrantedAuthority> getRole() {
        return role;
    }
}
