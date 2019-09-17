package com.breedmanager.repositories;

import com.breedmanager.entitis.Litter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LitterRepository extends JpaRepository<Litter, Long> {
}
