package com.breedmanager.interfaces;


import com.breedmanager.DTO.DogDTO;
import com.breedmanager.DTO.UserDTO;


public interface UserInterface {


    void editProfile(UserDTO userDTO);

    void addDog(DogDTO dogDTO);
    void viewDogs(UserDTO userDTO);
    void editDog(DogDTO dogDTO);



}
