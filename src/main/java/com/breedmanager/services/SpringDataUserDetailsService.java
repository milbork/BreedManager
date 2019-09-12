package com.breedmanager.services;

import com.breedmanager.data.CurrentUser;
import com.breedmanager.entitis.User;
import com.breedmanager.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.HashSet;
import java.util.Set;


public class SpringDataUserDetailsService implements UserDetailsService {

    private UserRepository userRepository;

    @Autowired
    public void getUserRepository(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(s);
        if(user==null) throw new UsernameNotFoundException(s);
        Set<GrantedAuthority> roles = new HashSet<>();
        user.getRoles().forEach( role -> roles.add(new SimpleGrantedAuthority(role.getName())));
        return new CurrentUser(user.getEmail(), user.getPassword(), roles, user);
    }
}