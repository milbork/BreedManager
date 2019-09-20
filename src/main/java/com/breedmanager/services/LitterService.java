package com.breedmanager.services;

import com.breedmanager.DTO.LitterDTO;
import com.breedmanager.entitis.Litter;
import com.breedmanager.interfaces.LitterInterface;
import com.breedmanager.repositories.DogRepository;
import com.breedmanager.repositories.LitterRepository;
import com.breedmanager.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class LitterService implements LitterInterface {

    private final DogRepository dogRepository;
    private final UserRepository userRepository;
    private final LitterRepository litterRepository;



    public LitterService(DogRepository dogRepository, UserRepository userRepository, LitterRepository litterRepository) {
        this.dogRepository = dogRepository;
        this.userRepository = userRepository;
        this.litterRepository = litterRepository;
    }


    @Override
    public void createLitter(LitterDTO litterDTO) {
        Litter litter = new Litter();
        litter.setBreeder(litterDTO.getBreeder());
        litter.setDateOfBirth(litterDTO.getDateOfBirth());
        litter.setAmountOfPuppies(litterDTO.getAmountOfPuppies());
        litterRepository.save(litter);
    }

    @Override
    public Set<Litter> readLitter(LitterDTO litterDTO) {
        return litterRepository.getLittersByBreederId(litterDTO.getId());
    }

    @Override
    public void updateLitter(LitterDTO litterDTO) {
        Litter litter = new Litter();
        litter.setId(litterDTO.getId());
        litter.setBreeder(litterDTO.getBreeder());
        litter.setDateOfBirth(litterDTO.getDateOfBirth());
        litter.setAmountOfPuppies(litterDTO.getAmountOfPuppies());
        litterRepository.save(litter);
    }

    @Override
    public void deleteLitter(Long id) {
        litterRepository.delete(litterRepository.getOne(id));
    }
}
