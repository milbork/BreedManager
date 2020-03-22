package com.breedmanager.interfaces;

import com.breedmanager.DTO.DogDTO;
import com.breedmanager.entitis.Dog;

import java.util.List;

public interface DogInterface {

    List<Dog> showDogs(Long id);

    void editDog(DogDTO dogDTO);

    void addDog(DogDTO dogDTO);

    void removeDog(Long id);

    boolean checkIfDogAlreadyExist(DogDTO dogDTO);

}
