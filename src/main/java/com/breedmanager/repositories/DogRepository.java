package com.breedmanager.repositories;

import com.breedmanager.entitis.Dog;
import com.breedmanager.entitis.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface DogRepository extends JpaRepository<Dog, Long> {

    List<Dog> findAllByOwnerId(Long id);

    Dog findByOwnerAndDateOfBirthAndBreedAndName(User owner, String date, String breed, String name);

}