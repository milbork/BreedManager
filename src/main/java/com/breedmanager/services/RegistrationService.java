package com.breedmanager.services;

import com.breedmanager.DTO.BreederDTO;
import com.breedmanager.DTO.UserDTO;
import com.breedmanager.entitis.Breeder;
import com.breedmanager.entitis.User;
import com.breedmanager.interfaces.RegistrationInterface;
import com.breedmanager.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService implements RegistrationInterface {

    @Autowired
    private UserRepository repository;

    @Override
    public Breeder addBreeder(BreederDTO breeder) {
        return null;
    }

    @Override
    public User addUser(UserDTO userDTO) {
        User user = new User();
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());
        return repository.save(user);
    }
}
