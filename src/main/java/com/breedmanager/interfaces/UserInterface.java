package com.breedmanager.interfaces;


import com.breedmanager.DTO.DogDTO;
import com.breedmanager.DTO.UserDTO;
import com.breedmanager.entitis.Dog;


public interface UserInterface {


    void editProfile(UserDTO userDTO);


    void viewDogs(UserDTO userDTO);




}
