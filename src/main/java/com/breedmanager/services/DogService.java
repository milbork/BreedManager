package com.breedmanager.services;

import com.breedmanager.DTO.DogDTO;
import com.breedmanager.DTO.UserDTO;
import com.breedmanager.entitis.Dog;
import com.breedmanager.interfaces.DogInterface;
import com.breedmanager.repositories.DogRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class DogService implements DogInterface {

    private final DogRepository dogRepository;


    public DogService(DogRepository dogRepository) {
        this.dogRepository = dogRepository;
    }

    @Override
    public void addDog(DogDTO dogDTO) {
        Dog dog = new Dog();
        dog.setName(dogDTO.getName());
        dog.setBreed(dogDTO.getBreed());
        dog.setDateOfBirth(dogDTO.getDateOfBirth());
        dog.setOwner(dogDTO.getOwner());
        dogRepository.save(dog);
    }

    @Override
    public List<Dog> showDogs(Long id) {
        return dogRepository.findAllByOwnerId(id);
    }

    @Override
    public void editDog(DogDTO dogDTO) {
        Dog dog = new Dog();
        dog.setId(dogDTO.getId());
        dog.setName(dogDTO.getName());
        dog.setBreed(dogDTO.getBreed());
        dog.setDateOfBirth(dogDTO.getDateOfBirth());
        dog.setOwner(dogDTO.getOwner());
        dogRepository.save(dog);
    }

    @Override
    public void removeDog(Long id) {
        dogRepository.delete(dogRepository.getOne(id));
    }

}


