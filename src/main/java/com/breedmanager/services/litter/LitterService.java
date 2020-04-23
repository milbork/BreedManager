package com.breedmanager.services.litter;

import com.breedmanager.model.DTO.LitterDTO;
import com.breedmanager.model.Litter;

import java.util.Set;

public interface LitterService {

    void createLitter(LitterDTO litterDTO);
    Set<Litter> readLitter(LitterDTO litterDTO);
    void updateLitter(LitterDTO litterDTO);
    void deleteLitter(Long id);
    Set<Litter> getLitters(String name);

}
