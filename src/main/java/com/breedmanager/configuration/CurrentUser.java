package com.breedmanager.configuration;

import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public class CurrentUser extends org.springframework.security.core.userdetails.User {

    private final com.breedmanager.model.User user;
    public CurrentUser(String email, String password,
                       Collection<? extends GrantedAuthority> authorities,
                       com.breedmanager.model.User user) {
        super(email, password, authorities);
        this.user = user;
    }
    public com.breedmanager.model.User getUser() {return user;}
}
