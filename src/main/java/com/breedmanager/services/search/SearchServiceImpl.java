package com.breedmanager.services.search;

import com.breedmanager.model.DTO.BreedingDTO;
import com.breedmanager.model.Breeding;
import com.breedmanager.repositories.BreedingRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchServiceImpl {

    private BreedingRepository breedingRepository;

    public SearchServiceImpl(BreedingRepository breedingRepository) {
        this.breedingRepository = breedingRepository;
    }

    public List<Breeding> searchForBreedingsByDogsBreed(String doggo) {
        return breedingRepository.findBreedingsByDogsBreed(doggo);
    }


    public List<Breeding> searchForBreedings(BreedingDTO breedingDTO) {

        if ((breedingDTO.getDogsBreed() != null) && (breedingDTO.getAvailable() != null)) {
            return breedingRepository.findByDogsBreedAndAvailableAllIgnoreCase(breedingDTO.getDogsBreed(), breedingDTO.getAvailable());
        } else if ((breedingDTO.getDogsBreed() == null) && (breedingDTO.getAvailable().equals("yes"))) {
            return breedingRepository.findAllByAvailable(breedingDTO.getAvailable());
        } else {
            return breedingRepository.findBreedingsByDogsBreed(breedingDTO.getDogsBreed());
        }
    }
}
