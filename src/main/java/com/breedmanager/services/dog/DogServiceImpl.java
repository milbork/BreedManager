package com.breedmanager.services.dog;

import com.breedmanager.model.DTO.DogDTO;
import com.breedmanager.model.Dog;
import com.breedmanager.repositories.DogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@CacheConfig(cacheNames = {"dogCache"})
public class DogServiceImpl implements DogService {

    private final DogRepository dogRepository;

    @Autowired
    public DogServiceImpl(DogRepository dogRepository) {
        this.dogRepository = dogRepository;
    }

    @Override
    public void addDog(DogDTO dogDTO) {
        Dog dog = new Dog();
        createAndEdit(dogDTO, dog);
    }

    @Override
    @Cacheable
    public List<Dog> showDogs(Long id) {
        return dogRepository.findAllByOwnerId(id);
    }

    @Override
    public void editDog(DogDTO dogDTO) {
        Dog dog = new Dog();
        dog.setId(dogDTO.getId());
        createAndEdit(dogDTO, dog);
    }

    @Override
    public void removeDog(Long id) {
        dogRepository.delete(dogRepository.getOne(id));
    }


    private void createAndEdit(DogDTO dogDTO, Dog dog) {
        dog.setName(dogDTO.getName());
        dog.setBreed(dogDTO.getBreed());
        dog.setDateOfBirth(dogDTO.getDateOfBirth());
        dog.setOwner(dogDTO.getOwner());
        dogRepository.save(dog);
    }

    @Override
    public boolean checkIfDogAlreadyExist(DogDTO dogDTO) {

        Optional<Dog> optionalDog = Optional.ofNullable(dogRepository.findByOwnerAndDateOfBirthAndBreedAndName
                (dogDTO.getOwner(), dogDTO.getDateOfBirth(), dogDTO.getBreed(), dogDTO.getName()));

        return optionalDog.isPresent();
    }

}


