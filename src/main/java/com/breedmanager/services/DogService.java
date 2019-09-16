package com.breedmanager.services;

import com.breedmanager.DTO.DogDTO;
import com.breedmanager.DTO.UserDTO;
import com.breedmanager.entitis.Dog;
import com.breedmanager.interfaces.DogInterface;
import com.breedmanager.repositories.DogRepository;
import com.breedmanager.repositories.RoleRepository;
import com.breedmanager.repositories.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class DogService implements DogInterface {

    private final DogRepository dogRepository;
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;

    public DogService(DogRepository dogRepository, UserRepository userRepository, BCryptPasswordEncoder passwordEncoder, RoleRepository roleRepository) {
        this.dogRepository = dogRepository;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.roleRepository = roleRepository;
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
    public void viewDogs(UserDTO userDTO) {

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
    public Dog getDogById(Long id) {
        return dogRepository.getOne(id);
    }

    public void removeDog(Long id) {
        dogRepository.delete(dogRepository.getOne(id));
    }

}


