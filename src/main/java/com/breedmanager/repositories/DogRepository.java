package com.breedmanager.repositories;

import com.breedmanager.entitis.Dog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DogRepository extends JpaRepository<Dog, Long> {

    List<Dog> findAllByOwnerId(Long id);
    void removeDogById(Long id);
}
