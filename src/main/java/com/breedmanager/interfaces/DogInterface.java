package com.breedmanager.interfaces;

import com.breedmanager.DTO.DogDTO;
import com.breedmanager.DTO.UserDTO;
import com.breedmanager.entitis.Dog;

public interface DogInterface {

    void viewDogs(UserDTO userDTO);

    void editDog(DogDTO dogDTO);

    Dog getDogById(Long id);

    void addDog(DogDTO dogDTO);

    void removeDog(Long id);


}
