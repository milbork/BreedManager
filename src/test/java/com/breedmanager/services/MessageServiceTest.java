package com.breedmanager.services;

import com.breedmanager.entitis.Message;
import com.breedmanager.entitis.User;
import com.breedmanager.repositories.MessageRepository;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class MessageServiceTest {

    @Test
    void sendMessage() {
    }

    @Test
    void findAllMessagesByReceiver() {
        List<Message> messages = preparingMethod();
        User user = new User("Jan", "Kowalski");
        MessageRepository messageRepository = mock(MessageRepository.class);
        MessageService messageService = new MessageService(messageRepository);
        when(messageService.findAllByReceiver(user)).thenReturn(messages);
    }

    @Test
    void findAllMessagesBySender() {
    }

    private List<Message> preparingMethod() {

        User user1 = new User("Jan", "Kowalski");
        User user2 = new User("Adam", "Nowak");
        User user3 = new User("Maria", "Xińska");


        Message message1 = new Message("message two text", user2, user1);
        Message message2 = new Message("message three text", user3, user1);

        List<Message> messages = new ArrayList<>();

        messages.add(message1);
        messages.add(message2);
;

        return messages;
    }
}