package com.breedmanager.services.breeding;

import com.breedmanager.model.DTO.BreedingDTO;
import com.breedmanager.model.Breeding;
import com.breedmanager.model.User;
import com.breedmanager.repositories.BreedingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@CacheConfig(cacheNames={"breeding"})
public class BreedingServiceImpl implements BreedingService {

    private final BreedingRepository breedingRepository;

    @Autowired
    public BreedingServiceImpl(BreedingRepository breedingRepository) {
        this.breedingRepository = breedingRepository;
    }

    @Override
    public void addBreeding(BreedingDTO breedingDTO) {
        Breeding breeding = new Breeding();
        createAndEdit(breedingDTO, breeding);
    }

    @Override
    public void editBreeding(BreedingDTO breedingDTO) {
        Breeding breeding = new Breeding();
        breeding.setId(breedingDTO.getId());
        createAndEdit(breedingDTO, breeding);
    }

    @Override
    public void deleteBreeding(Long id) {
        breedingRepository.deleteById(id);
    }

    @Override
    @Cacheable
    public Breeding findBreedingByBreeder(User user) {
        return breedingRepository.findBreedingByBreeder(user);
    }

    private void createAndEdit(BreedingDTO breedingDTO, Breeding breeding) {
        breeding.setBreeder(breedingDTO.getBreeder());
        breeding.setDogsBreed(breedingDTO.getDogsBreed());
        breeding.setName(breedingDTO.getName());
        breeding.setAvailable(breedingDTO.getAvailable());
        breedingRepository.save(breeding);
    }



}
