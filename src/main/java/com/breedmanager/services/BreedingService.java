package com.breedmanager.services;

import com.breedmanager.DTO.BreedingDTO;
import com.breedmanager.entitis.Breeding;
import com.breedmanager.entitis.User;
import com.breedmanager.repositories.BreedingRepository;
import com.breedmanager.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BreedingService {

    private final BreedingRepository breedingRepository;
    private final UserRepository userRepository;

    public BreedingService(BreedingRepository breedingRepository, UserRepository userRepository) {
        this.breedingRepository = breedingRepository;
        this.userRepository = userRepository;
    }

    public void addBreeding(BreedingDTO breedingDTO) {
        Breeding breeding = new Breeding();
        breeding.setBreeder(breedingDTO.getBreeder());
        breeding.setDogsBreed(breedingDTO.getDogsBreed());
        breeding.setName(breedingDTO.getName());
        breedingRepository.save(breeding);
    }

    public Breeding getBreeding(User user) {
        return breedingRepository.findBreedingByBreeder(user);
    }

    public List<Breeding> findBreedings(String doggo){
        return breedingRepository.findBreedingsByDogsBreed(doggo);
    }
}
