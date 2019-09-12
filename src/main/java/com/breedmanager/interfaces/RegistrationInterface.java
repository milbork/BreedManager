package com.breedmanager.interfaces;


import com.breedmanager.DTO.UserDTO;
import com.breedmanager.entitis.User;

public interface RegistrationInterface {

    void addUser(UserDTO userDTO);
    User findUserByEmail(String email);

}
