package com.breedmanager.services;

import com.breedmanager.repositories.MessageRepository;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;

class MessageServiceTest {

    @Test
    void sendMessage() {
    }

    @Test
    void findAllByReceiver() {
        MessageRepository  messageRepository = mock(MessageRepository.class);
        MessageService messageService = new MessageService(messageRepository);
    }

    @Test
    void findAllBySender() {
    }
}