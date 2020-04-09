package com.breedmanager.repositories;

import com.breedmanager.Application;
import com.breedmanager.entitis.Message;
import com.breedmanager.entitis.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestEntityManager;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = Application.class)
@AutoConfigureTestEntityManager
@Transactional
class MessageRepositoryTest {

    @Autowired
    TestEntityManager entityManager;

    @Autowired
    MessageRepository repository;

    @Test
    void shouldPassIfReturnsCorrectMessagesBySenderAndReceiver() {
        User user = new User();
        User user1 = new User();
        Message message = new Message("text", user, user1);
        Message message1 = new Message("text text", user1, user);

        List<Message> messages = new ArrayList<>();
        messages.add(message);

        entityManager.persistAndFlush(user);
        entityManager.persistAndFlush(user1);
        entityManager.persistAndFlush(message);
        entityManager.persistAndFlush(message1);

        List<Message> foundByReceiver = repository.findMessagesByReceiver(user1);
        List<Message> foundBySender = repository.findMessagesBySender(user);
        assertThat(foundByReceiver).isEqualTo(messages);
        assertThat(foundBySender).isEqualTo(messages);

    }

    @Test
    void shouldReturnEmptyListIfCantFindAMessage() {
        User user = new User();
        User user1 = new User();
        User user2 = new User();
        Message message = new Message("text", user, user1);
        Message message1 = new Message("text text", user1, user);

        entityManager.persistAndFlush(user);
        entityManager.persistAndFlush(user1);
        entityManager.persistAndFlush(user2);
        entityManager.persistAndFlush(message);
        entityManager.persistAndFlush(message1);

        List<Message> foundByReceiver = repository.findMessagesByReceiver(user2);
        List<Message> foundBySender = repository.findMessagesBySender(user2);

        assertThat(foundByReceiver).isEmpty();
        assertThat(foundBySender).isEmpty();

    }
}