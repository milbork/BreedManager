package com.breedmanager.interfaces;

import com.breedmanager.DTO.LitterDTO;
import com.breedmanager.entitis.Litter;

public interface LitterInterface {

    void createLitter(LitterDTO litterDTO);
    Litter readLitter(LitterDTO litterDTO);
    void updateLitter(LitterDTO litterDTO);
    void deleteLitter(Long id);
}
