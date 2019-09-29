package com.breedmanager.interfaces;


import com.breedmanager.DTO.UserDTO;
import com.breedmanager.entitis.Dog;

import java.util.List;


public interface UserInterface {

    void addUser(UserDTO userDTO);

    void editProfile(UserDTO userDTO);

    void viewDogs(UserDTO userDTO);

     List<Dog> getDogsForUser(Long id);
     String getUsersDataById(Long id);
     String getUsersFunctionById(Long id);
     void removeUser(Long id);



}
