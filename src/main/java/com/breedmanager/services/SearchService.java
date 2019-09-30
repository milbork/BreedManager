package com.breedmanager.services;

import com.breedmanager.DTO.BreedingDTO;
import com.breedmanager.entitis.Breeding;
import com.breedmanager.entitis.Litter;
import com.breedmanager.repositories.BreedingRepository;
import com.breedmanager.repositories.LitterRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SearchService {

    private BreedingRepository breedingRepository;
    private LitterRepository litterRepository;

    public SearchService(BreedingRepository breedingRepository, LitterRepository litterRepository) {
        this.breedingRepository = breedingRepository;
        this.litterRepository = litterRepository;
    }

    public List<Breeding> searchForBreedingsByDogsBreed(String doggo) {
        return breedingRepository.findBreedingsByDogsBreed(doggo);
    }

    public List<Breeding> searchForBreedingsByDogsBreedAndAvailability(String doggo) {
        List<Litter> litters = litterRepository.findLittersByDogsBreedAndAvailableIsTrue(doggo);
        List<Breeding> breedings = new ArrayList<>();
        for (Litter l : litters) {
            breedings.add(l.getBreeding());
        }
        return breedings;
    }

    public List<Breeding> searchForBreedings(BreedingDTO breedingDTO){

        if ((breedingDTO.getName()!=null)&&(breedingDTO.getDogsBreed()!=null)&&(breedingDTO.isAvailable())){

        }
        return null;
    }

}
