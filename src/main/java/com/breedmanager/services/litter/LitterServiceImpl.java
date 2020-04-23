package com.breedmanager.services.litter;

import com.breedmanager.model.DTO.LitterDTO;
import com.breedmanager.model.Litter;
import com.breedmanager.repositories.LitterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@CacheConfig(cacheNames = {"litterCache"})
public class LitterServiceImpl implements LitterService {


    private final LitterRepository litterRepository;

    @Autowired
    public LitterServiceImpl(LitterRepository litterRepository) {
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
