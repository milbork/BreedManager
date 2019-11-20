package com.breedmanager.services;

import com.breedmanager.DTO.UserDTO;
import com.breedmanager.entitis.Role;
import com.breedmanager.entitis.User;
import com.breedmanager.interfaces.UserInterface;
import com.breedmanager.repositories.RoleRepository;
import com.breedmanager.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;

@Service
public class UserService implements UserInterface {


    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;

    @Autowired
    public UserService(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.roleRepository = roleRepository;
    }

    @Override
    public void addUser(UserDTO userDTO) {
        User user = new User();
        createUser(user, userDTO);
        userRepository.save(user);
    }


    @Override
    public void editProfile(UserDTO userDTO) {
        User user = new User();
        user.setId(userDTO.getId());
        createUser(user, userDTO);
        userRepository.save(user);
    }

    private User createUser(User user, UserDTO userDTO) {
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setEmail(userDTO.getEmail());
        user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        user.setFunction(userDTO.getFunction());
        if (userDTO.getFunction().equals("owner")) {
            Role userRole = roleRepository.findByName("ROLE_USER");
            user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
        } else if (userDTO.getFunction().equals("breeder")) {
            Role userRole = roleRepository.findByName("ROLE_BREEDER");
            user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
        }
        user.setEnabled(1);
        return user;
    }


    @Override
    public String getUsersDataById(Long id) {
        return userRepository.findUserById(id).getFirstName();
    }

    @Override
    public String getUsersFunctionById(Long id) {
        return userRepository.findUserById(id).getFunction();
    }

    @Override
    public void removeUser(Long id) {
        userRepository.delete(userRepository.getOne(id));
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findUserById(id);
    }

}
