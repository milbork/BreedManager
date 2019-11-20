package com.breedmanager.services;

import com.breedmanager.DTO.BreedingDTO;
import com.breedmanager.entitis.Breeding;
import com.breedmanager.entitis.User;
import com.breedmanager.interfaces.BreedingInterface;
import com.breedmanager.repositories.BreedingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BreedingService implements BreedingInterface {

    private final BreedingRepository breedingRepository;

    @Autowired
    public BreedingService(BreedingRepository breedingRepository) {
        this.breedingRepository = breedingRepository;
    }

    @Override
    public void addBreeding(BreedingDTO breedingDTO) {
        Breeding breeding = new Breeding();
        createAndEdit(breedingDTO, breeding);
    }

    @Override
    public void editBreeding(BreedingDTO breedingDTO) {
        Breeding breeding = new Breeding();
        breeding.setId(breedingDTO.getId());
        createAndEdit(breedingDTO, breeding);
    }

    @Override
    public void deleteBreeding(Long id) {
        breedingRepository.deleteById(id);
    }

    @Override
    public Breeding findBreedingByBreeder(User user) {
        return breedingRepository.findBreedingByBreeder(user);
    }

    private void createAndEdit(BreedingDTO breedingDTO, Breeding breeding) {
        breeding.setBreeder(breedingDTO.getBreeder());
        breeding.setDogsBreed(breedingDTO.getDogsBreed());
        breeding.setName(breedingDTO.getName());
        breeding.setAvailable(breedingDTO.getAvailable());
        breedingRepository.save(breeding);
    }
}