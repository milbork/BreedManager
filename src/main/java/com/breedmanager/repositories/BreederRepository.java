package com.breedmanager.repositories;

import com.breedmanager.entitis.Breeder;
import com.breedmanager.entitis.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories(basePackages = "com.breedmanager.repositories")
public interface BreederRepository extends JpaRepository<Breeder, Long > {

    Breeder findByEmail(String email);
}
