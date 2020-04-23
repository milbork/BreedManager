package com.breedmanager.services.user;


import com.breedmanager.model.DTO.UserDTO;

import com.breedmanager.model.User;



public interface UserService {

    void createUser(UserDTO userDTO);

    void editProfile(UserDTO userDTO);

    void removeUser(Long id);

    User getUserById(Long id);

    boolean checkIfUserAlreadyExist(UserDTO user);

    boolean checkIfEmailIsAlreadyUsed(String currentEmail, UserDTO userDTO);

}
