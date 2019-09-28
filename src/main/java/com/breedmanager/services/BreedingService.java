package com.breedmanager.services;

import com.breedmanager.DTO.BreedingDTO;
import com.breedmanager.entitis.Breeding;
import com.breedmanager.repositories.BreedingRepository;
import org.springframework.stereotype.Service;

@Service
public class BreedingService {

    private final BreedingRepository breedingRepository;

    public BreedingService(BreedingRepository breedingRepository) {
        this.breedingRepository = breedingRepository;
    }

    public void addBreeding(BreedingDTO breedingDTO) {
        Breeding breeding = new Breeding();
        breeding.setBreeder(breedingDTO.getBreeder());
        breeding.setDogsBreed(breedingDTO.getDogsBreed());
        breeding.setName(breedingDTO.getName());
        breedingRepository.save(breeding);
    }
}
