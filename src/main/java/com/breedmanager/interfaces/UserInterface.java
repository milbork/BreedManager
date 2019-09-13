package com.breedmanager.interfaces;


import com.breedmanager.DTO.DogDTO;
import com.breedmanager.DTO.UserDTO;
import com.breedmanager.entitis.Dog;
import com.breedmanager.entitis.User;

public interface UserInterface {


void editProfile(UserDTO userDTO);
    void addDog(DogDTO dogDTO);

}
