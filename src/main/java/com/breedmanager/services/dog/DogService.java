package com.breedmanager.services.dog;

import com.breedmanager.model.DTO.DogDTO;
import com.breedmanager.model.Dog;

import java.util.List;

public interface DogService {

    List<Dog> showDogs(Long id);

    void editDog(DogDTO dogDTO);

    void addDog(DogDTO dogDTO);

    void removeDog(Long id);

    boolean checkIfDogAlreadyExist(DogDTO dogDTO);

}
