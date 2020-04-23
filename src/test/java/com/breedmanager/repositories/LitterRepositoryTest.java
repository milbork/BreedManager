package com.breedmanager.repositories;

import com.breedmanager.Application;
import com.breedmanager.model.Breeding;
import com.breedmanager.model.Litter;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestEntityManager;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(classes = Application.class)
@AutoConfigureTestEntityManager
@Transactional
class LitterRepositoryTest {

    @Autowired
    TestEntityManager entityManager;

    @Autowired
    LitterRepository repository;

    @Test
    void shouldPassIfFoundCorrectSetOfLitters() {
        Breeding breeding = new Breeding("breeding");
        Litter litter = new Litter(breeding);
        Breeding breeding1 = new Breeding("breeding1");
        Litter litter1 = new Litter(breeding1);

        entityManager.persistAndFlush(breeding);
        entityManager.persistAndFlush(litter);
        entityManager.persistAndFlush(breeding1);
        entityManager.persistAndFlush(litter1);

        Set<Litter> litters = new HashSet<>();
        litters.add(litter);
        Set<Litter> found = repository.findAllByBreedingName("breeding");

        assertThat(found).isEqualTo(litters);

    }

    @Test
    void shouldReturnEmptySetIfCantFindLitter() {
        Breeding breeding = new Breeding("breeding");
        Litter litter = new Litter(breeding);
        Breeding breeding1 = new Breeding("breeding1");
        Litter litter1 = new Litter(breeding1);

        entityManager.persistAndFlush(breeding);
        entityManager.persistAndFlush(litter);
        entityManager.persistAndFlush(breeding1);
        entityManager.persistAndFlush(litter1);

        Set<Litter> found = repository.findAllByBreedingName("breeding2");

        assertThat(found).isEmpty();

    }
}
