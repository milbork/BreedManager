package com.breedmanager.repositories;

import com.breedmanager.entitis.Breeding;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BreedingRepository extends JpaRepository<Breeding, Long> {

    List<Breeding> findAllByBreederId(Long id);
}
