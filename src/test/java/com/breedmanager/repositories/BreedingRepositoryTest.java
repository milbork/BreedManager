package com.breedmanager.repositories;

import com.breedmanager.Application;
import com.breedmanager.model.Breeding;
import com.breedmanager.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestEntityManager;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest(classes = Application.class)
@AutoConfigureTestEntityManager
@Transactional
class BreedingRepositoryTest {

    @Autowired
    private BreedingRepository breedingRepository;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    void findBreedingByBreeder() {

        User user = new User();
        Breeding breeding = new Breeding("breedingName", "kundel", user, "true");
        entityManager.persistAndFlush(user);
        entityManager.persistAndFlush(breeding);

        Breeding found = breedingRepository.findBreedingByBreeder(user);
        assertThat(found).isEqualTo(breeding);
    }

    @Test
    void findBreedingsByDogsBreed() {

        User user = new User();
        Breeding breeding = new Breeding("breedingName", "golden", user, "true");
        Breeding breeding2 = new Breeding("breedingName2", "golden", user, "false");
        List<Breeding> breedings = new ArrayList<>();

        breedings.add(breeding);
        breedings.add(breeding2);

        entityManager.persistAndFlush(user);
        entityManager.persistAndFlush(breeding);
        entityManager.persistAndFlush(breeding2);

        List<Breeding> found = breedingRepository.findBreedingsByDogsBreed("golden");
        assertThat(found).isEqualTo(breedings);

    }

    @Test
    void findAllByAvailability() {
        User user = new User();
        Breeding breeding = new Breeding("breedingName", "labrador", user, "true");
        Breeding breeding2 = new Breeding("breedingName2", "labrador", user, "false");
        List<Breeding> breedings = new ArrayList<>();

        breedings.add(breeding);

        entityManager.persistAndFlush(user);
        entityManager.persistAndFlush(breeding);
        entityManager.persistAndFlush(breeding2);

        List<Breeding> found = breedingRepository.findAllByAvailable("true");
        assertThat(found).isEqualTo(breedings);
    }

    @Test
    void findByDogsBreedAndAvailableAllIgnoreCase() {
        User user = new User();
        Breeding breeding = new Breeding("breedingName", "sheppard", user, "true");
        Breeding breeding2 = new Breeding("breedingName2", "sheppard", user, "false");
        Breeding breeding3 = new Breeding("breedingName3", "german sheppard", user, "true");
        List<Breeding> breedings = new ArrayList<>();

        breedings.add(breeding);

        entityManager.persistAndFlush(user);
        entityManager.persistAndFlush(breeding);
        entityManager.persistAndFlush(breeding2);
        entityManager.persistAndFlush(breeding3);

        List<Breeding> found = breedingRepository.
                findByDogsBreedAndAvailableAllIgnoreCase("sheppard", "true");
        assertThat(found).isEqualTo(breedings);
    }

    @Test
    void shouldReturnNullOrEmptyListIfCantFindBreeding() {
        User user = new User();
        User user1 = new User();
        Breeding breeding = new Breeding("breedingName", "sheppard", user, "true");
        Breeding breeding2 = new Breeding("breedingName2", "sheppard", user, "true");
        Breeding breeding3 = new Breeding("breedingName3", "german sheppard", user, "true");
        List<Breeding> breedings = new ArrayList<>();

        breedings.add(breeding);

        entityManager.persistAndFlush(user);
        entityManager.persistAndFlush(user1);
        entityManager.persistAndFlush(breeding);
        entityManager.persistAndFlush(breeding2);
        entityManager.persistAndFlush(breeding3);

        Breeding found = breedingRepository.findBreedingByBreeder(user1);
        assertThat(found).isNull();

        List<Breeding> breedingList = breedingRepository.findBreedingsByDogsBreed("jamnik");
        assertThat(breedingList).isNullOrEmpty();

        List<Breeding> breedingList2 = breedingRepository.findAllByAvailable("false");
        assertThat(breedingList2).isNullOrEmpty();

        List<Breeding> breedingList3 = breedingRepository.
                findByDogsBreedAndAvailableAllIgnoreCase("jamnik", "true");
        assertThat(breedingList3).isNullOrEmpty();
    }
}
