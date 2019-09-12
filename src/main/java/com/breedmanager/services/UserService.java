package com.breedmanager.services;

import com.breedmanager.DTO.DogDTO;
import com.breedmanager.entitis.Dog;
import com.breedmanager.interfaces.UserInterface;
import com.breedmanager.repositories.DogRepository;
import com.breedmanager.repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserInterface {

    private final DogRepository dogRepository;
    private final  UserRepository userRepository;

    public UserService(DogRepository dogRepository, UserRepository userRepository) {
        this.dogRepository = dogRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void addDog(DogDTO dogDTO) {
        Dog dog = new Dog();
        dog.setName(dogDTO.getName());
        dog.setBreed(dogDTO.getBreed());
        dog.setDateOfBirth(dogDTO.getDateOfBirth( ));
        dog.setOwner(dogDTO.getOwner());
        dogRepository.save(dog);
    }
}
