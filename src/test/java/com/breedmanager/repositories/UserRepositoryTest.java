package com.breedmanager.repositories;

import com.breedmanager.Application;
import com.breedmanager.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestEntityManager;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest(classes = Application.class)
@AutoConfigureTestEntityManager
@Transactional
class UserRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;
    @Autowired
    private UserRepository repository;


    @Test
    void shouldPassIfFoundCorrectUserByEmail() {

        entityManager.persistAndFlush(new User("Adam", "Nowak", "adam@nowak.pl"));
        User user = this.repository.findUserByEmail("adam@nowak.pl");
        assertThat(user.getEmail()).isEqualTo("adam@nowak.pl");
    }
    @Test
    void shouldPassIfFoundCorrectUserByID() {
        User testUser = new User("Adam", "Nowak", "adam@nowak.pl");
        entityManager.persistAndFlush(testUser);
        User user = this.repository.findUserById(testUser.getId());
        assertThat(user).isEqualTo(testUser);

    }


}
