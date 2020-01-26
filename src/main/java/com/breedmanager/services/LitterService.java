package com.breedmanager.services;

import com.breedmanager.DTO.LitterDTO;
import com.breedmanager.entitis.Litter;
import com.breedmanager.interfaces.LitterInterface;
import com.breedmanager.repositories.DogRepository;
import com.breedmanager.repositories.LitterRepository;
import com.breedmanager.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@CacheConfig(cacheNames = {"litterCache"})
public class LitterService implements LitterInterface {


    private final LitterRepository litterRepository;

    @Autowired
    public LitterService(LitterRepository litterRepository) {
        this.litterRepository = litterRepository;
    }


    @Override
    public void createLitter(LitterDTO litterDTO) {
        Litter litter = new Litter();
        litter.setBreeding(litterDTO.getBreeding());
        litter.setDogsBreed(litterDTO.getDogsBreed());
        litter.setDateOfBirth(litterDTO.getDateOfBirth());
        litter.setAmountOfPuppies(litterDTO.getAmountOfPuppies());
        litterRepository.save(litter);
    }

    @Override
    @Cacheable
    public Set<Litter> readLitter(LitterDTO litterDTO) {
        return litterRepository.findAllByBreedingName(litterDTO.getBreeding().getName());
    }

    @Override
    public void updateLitter(LitterDTO litterDTO) {
        Litter litter = new Litter();
        litter.setId(litterDTO.getId());
        createLitter(litterDTO);
    }

    @Override
    public void deleteLitter(Long id) {
        litterRepository.delete(litterRepository.getOne(id));
    }

    @Override
    public Set<Litter> getLitters(String name) {
        return litterRepository.findAllByBreedingName(name);
    }
}
