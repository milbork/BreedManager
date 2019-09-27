package com.breedmanager.interfaces;


import com.breedmanager.DTO.UserDTO;


public interface UserInterface {

    void addUser(UserDTO userDTO);

    void editProfile(UserDTO userDTO);

    void viewDogs(UserDTO userDTO);




}
