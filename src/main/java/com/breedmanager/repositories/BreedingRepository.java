package com.breedmanager.repositories;

import com.breedmanager.entitis.Breeding;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BreedingRepository extends JpaRepository<Breeding, Long> {

}
