package com.breedmanager.services;

import com.breedmanager.interfaces.LoginInterface;
import com.breedmanager.repositories.BreederRepository;
import com.breedmanager.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService implements LoginInterface {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BreederRepository breederRepository;

    @Override
    public Object login(Object userType) {
        return null;
    }
}
