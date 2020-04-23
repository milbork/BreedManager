package com.breedmanager.services.breeding;

import com.breedmanager.model.DTO.BreedingDTO;
import com.breedmanager.model.Breeding;
import com.breedmanager.model.User;

public interface BreedingService {

    void addBreeding(BreedingDTO breedingDTO);

    Breeding findBreedingByBreeder(User user);

    void editBreeding(BreedingDTO breedingDTO);

    void deleteBreeding(Long id);

}
