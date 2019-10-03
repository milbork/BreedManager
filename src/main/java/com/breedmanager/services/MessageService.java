package com.breedmanager.services;

import com.breedmanager.DTO.MessageDTO;
import com.breedmanager.entitis.Message;
import com.breedmanager.repositories.MessageRepository;
import org.springframework.stereotype.Service;

@Service
public class MessageService {

    private MessageRepository messageRepository;

    public MessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    public void sendMessage(MessageDTO messageDTO){
        Message message = new Message();
        message.setSender(messageDTO.getSender());
        message.setRecipientsID(messageDTO.getRecipientsID());
        message.setMessage(messageDTO.getMessage());
        messageRepository.save(message);
    }
}
