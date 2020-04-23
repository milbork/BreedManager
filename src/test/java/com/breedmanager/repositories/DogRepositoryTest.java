package com.breedmanager.repositories;

import com.breedmanager.Application;
import com.breedmanager.model.Dog;
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
class DogRepositoryTest {

    @Autowired
    TestEntityManager entityManager;

    @Autowired
    DogRepository repository;

    @Test
    void shouldPassIfOwnersIdIsCorrect() {
        User user = new User();
        Dog dog = new Dog("kundel", "burek", user, "01.01.2020");
        Dog dog2 = new Dog("kundel", "azor", user, "01.01.2010");

        List<Dog> dogs = new ArrayList<>();
        dogs.add(dog);
        dogs.add(dog2);

        entityManager.persistAndFlush(user);
        entityManager.persistAndFlush(dog);
        entityManager.persistAndFlush(dog2);

        List<Dog> found = repository.findAllByOwnerId(user.getId());
        assertThat(found).isEqualTo(dogs);
    }

    @Test
    void findByOwnerAndDateOfBirthAndBreedAndName() {
        User user = new User();
        entityManager.persistAndFlush(user);
        Dog dog = new Dog("kundel", "burek", user, "01.01.2020");
        entityManager.persistAndFlush(dog);
        Dog found = repository.findByOwnerAndDateOfBirthAndBreedAndName(user, "01.01.2020",
                "kundel", "burek");
        assertThat(found).isEqualTo(dog);
    }

    @Test
    void shouldReturnNullOrEmptyListWhenCantFindDog() {
        User user = new User();
        entityManager.persistAndFlush(user);

        Dog found = repository.findByOwnerAndDateOfBirthAndBreedAndName(null, null,
                null, null);
        List<Dog> dogs = repository.findAllByOwnerId(user.getId());

        assertThat(found).isNull();
        assertThat(dogs).isNullOrEmpty();
    }
}
