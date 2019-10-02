package com.breedmanager.services;

import com.breedmanager.DTO.BreedingDTO;
import com.breedmanager.entitis.Breeding;
import com.breedmanager.repositories.BreedingRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchService {

    private BreedingRepository breedingRepository;

    public SearchService(BreedingRepository breedingRepository) {
        this.breedingRepository = breedingRepository;
    }

    public List<Breeding> searchForBreedingsByDogsBreed(String doggo) {
        return breedingRepository.findBreedingsByDogsBreed(doggo);
    }


    public List<Breeding> searchForBreedings(BreedingDTO breedingDTO) {

//        if ((breedingDTO.getDogsBreed() != null) && (breedingDTO.getAvailable().equals("yes"))) {
//            return breedingRepository.findBreedingsByDogsBreedAndAvailable(breedingDTO.getDogsBreed(), breedingDTO.getAvailable());
//        } else if ((breedingDTO.getDogsBreed() == null) && (breedingDTO.getAvailable().equals("yes"))) {
//            return breedingRepository.findBreedingsByAvailable(breedingDTO.getAvailable());
//        } else {
            return breedingRepository.findBreedingsByDogsBreed(breedingDTO.getDogsBreed());

    }
}