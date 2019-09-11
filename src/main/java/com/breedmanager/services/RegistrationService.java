package com.breedmanager.services;

import com.breedmanager.DTO.BreederDTO;
import com.breedmanager.DTO.UserDTO;
import com.breedmanager.entitis.Breeder;
import com.breedmanager.entitis.User;
import com.breedmanager.interfaces.RegistrationInterface;
import com.breedmanager.repositories.BreederRepository;
import com.breedmanager.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService implements RegistrationInterface {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BreederRepository breederRepository;

    @Override
    public Breeder addBreeder(BreederDTO breederDTO) {

        Breeder breeder = new Breeder();
        breeder.setFirstName(breederDTO.getFirstName());
        breeder.setLastName(breederDTO.getLastName());
        breeder.setEmail(breederDTO.getEmail());
        breeder.setPassword(breederDTO.getPassword());
        breeder.setBreedingName(breederDTO.getBreedingName());
        return breederRepository.save(breeder);
    }

    @Override
    public User addUser(UserDTO userDTO) {
        User user = new User();
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());
        return userRepository.save(user);
    }

    @Override
    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public Breeder findBreederByEmail(String email) {
        return breederRepository.findByEmail(email);
    }
}
