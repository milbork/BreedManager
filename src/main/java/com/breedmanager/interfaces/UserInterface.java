package com.breedmanager.interfaces;


import com.breedmanager.DTO.UserDTO;

import com.breedmanager.entitis.User;



public interface UserInterface {

    void createUser(UserDTO userDTO);

    void editProfile(UserDTO userDTO);

    void removeUser(Long id);

    User getUserById(Long id);

    boolean checkIfUserAlreadyExist(UserDTO user);

    boolean checkIfEmailIsAlreadyUsed(String currentEmail, UserDTO userDTO);

}
