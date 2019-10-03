package com.breedmanager.services;

import com.breedmanager.DTO.BreedingDTO;
import com.breedmanager.entitis.Breeding;
import com.breedmanager.entitis.User;
import com.breedmanager.interfaces.BreedingInterface;
import com.breedmanager.repositories.BreedingRepository;
import com.breedmanager.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BreedingService implements BreedingInterface {

    private final BreedingRepository breedingRepository;

    public BreedingService(BreedingRepository breedingRepository) {
        this.breedingRepository = breedingRepository;
    }

    @Override
    public void addBreeding(BreedingDTO breedingDTO) {
        Breeding breeding = new Breeding();
        breeding.setBreeder(breedingDTO.getBreeder());
        breeding.setDogsBreed(breedingDTO.getDogsBreed());
        breeding.setName(breedingDTO.getName());
        breeding.setAvailable(breedingDTO.getAvailable());
        breedingRepository.save(breeding);
    }

    @Override
    public Breeding findBreedingByBreeder(User user) {
        return breedingRepository.findBreedingByBreeder(user);
    }

    @Override
    public void editBreeding(BreedingDTO breedingDTO) {
        Breeding breeding = new Breeding();
        breeding.setId(breedingDTO.getId());
        breeding.setBreeder(breedingDTO.getBreeder());
        breeding.setDogsBreed(breedingDTO.getDogsBreed());
        breeding.setName(breedingDTO.getName());
        breeding.setAvailable(breedingDTO.getAvailable());
        breedingRepository.save(breeding);
    }

    @Override
    public void deleteBreeding(Long id) {

    }


}
