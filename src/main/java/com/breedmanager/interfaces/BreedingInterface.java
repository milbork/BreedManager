package com.breedmanager.interfaces;

import com.breedmanager.DTO.BreedingDTO;
import com.breedmanager.entitis.Breeding;
import com.breedmanager.entitis.User;

public interface BreedingInterface {

    void addBreeding(BreedingDTO breedingDTO);

    Breeding findBreedingByBreeder(User user);

    void editBreeding(BreedingDTO breedingDTO);

    void deleteBreeding(Long id);

}
