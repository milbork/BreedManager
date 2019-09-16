package com.breedmanager.services;

import com.breedmanager.DTO.UserDTO;
import com.breedmanager.entitis.Dog;
import com.breedmanager.entitis.Role;
import com.breedmanager.entitis.User;
import com.breedmanager.interfaces.UserInterface;
import com.breedmanager.repositories.DogRepository;
import com.breedmanager.repositories.RoleRepository;
import com.breedmanager.repositories.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

@Service
public class UserService implements UserInterface {


    private final DogRepository dogRepository;
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;

    public UserService(DogRepository dogRepository, UserRepository userRepository, BCryptPasswordEncoder passwordEncoder, RoleRepository roleRepository) {
        this.dogRepository = dogRepository;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.roleRepository = roleRepository;
    }

    public String getUsersDataById(Long id) {
        return userRepository.findUserById(id).getFirstName();
    }

    @Override
    public void editProfile(UserDTO userDTO) {
        User user = new User();
        user.setId(userDTO.getId());
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setEmail(userDTO.getEmail());
        user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        user.setBreedingName(userDTO.getBreedingName());
        user.setEnabled(1);
        Role userRole = roleRepository.findByName("ROLE_USER");
        user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
        userRepository.save(user);
    }


    @Override
    public void viewDogs(UserDTO userDTO) {

    }

    public List<Dog> getDogsForUser(Long id) {
        return dogRepository.findAllByOwnerId(id);
    }

    public void removeUser(Long id) {
        userRepository.delete(userRepository.getOne(id));
    }

}
