package com.breedmanager.interfaces;


import com.breedmanager.DTO.BreederDTO;
import com.breedmanager.DTO.UserDTO;
import com.breedmanager.entitis.Breeder;
import com.breedmanager.entitis.User;

public interface RegistrationInterface {

    Breeder addBreeder(BreederDTO breeder);
    User addUser(UserDTO userDTO);
    User findUserByEmail(String email);
    Breeder findBreederByEmail(String email);
}
