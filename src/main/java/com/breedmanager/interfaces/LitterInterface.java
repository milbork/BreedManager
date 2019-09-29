package com.breedmanager.interfaces;

import com.breedmanager.DTO.LitterDTO;
import com.breedmanager.entitis.Litter;

import java.util.Set;

public interface LitterInterface {

    void createLitter(LitterDTO litterDTO);
    Set<Litter> readLitter(LitterDTO litterDTO);
    void updateLitter(LitterDTO litterDTO);
    void deleteLitter(Long id);
    Set<Litter> getLitters(String name);
}
