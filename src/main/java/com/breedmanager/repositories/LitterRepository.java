package com.breedmanager.repositories;


import com.breedmanager.entitis.Litter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface LitterRepository extends JpaRepository<Litter, Long> {

    Set<Litter> findAllByBreedingName(String name);

}
