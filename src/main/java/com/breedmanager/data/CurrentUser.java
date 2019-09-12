package com.breedmanager.data;

import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public class CurrentUser extends org.springframework.security.core.userdetails.User {

    private final com.breedmanager.entitis.User user;
    public CurrentUser(String email, String password,
                       Collection<? extends GrantedAuthority> authorities,
                       com.breedmanager.entitis.User user) {
        super(email, password, authorities);
        this.user = user;
    }
    public com.breedmanager.entitis.User getUser() {return user;}
}
