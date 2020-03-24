package com.breedmanager.interfaces;


import com.breedmanager.DTO.UserDTO;

import com.breedmanager.entitis.User;

import java.util.List;


public interface UserInterface {

    void addUser(UserDTO userDTO);

    void editProfile(UserDTO userDTO);

    String getUsersDataById(Long id);

    String getUsersFunctionById(Long id);

    void removeUser(Long id);

    User getUserById(Long id);

    boolean checkIfUserAlreadyExist(UserDTO user);

    boolean checkIfEmailIsAlreadyUsed(String currentEmail, UserDTO userDTO);

}
