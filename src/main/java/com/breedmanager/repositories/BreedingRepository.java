package com.breedmanager.repositories;

import com.breedmanager.model.Breeding;
import com.breedmanager.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface BreedingRepository extends JpaRepository<Breeding, Long> {

    Breeding findBreedingByBreeder(User user);

    List<Breeding> findBreedingsByDogsBreed(String dogsBreed);
    List<Breeding> findAllByAvailable(String available);
    List<Breeding> findByDogsBreedAndAvailableAllIgnoreCase(String dogsBreed, String available);
}
