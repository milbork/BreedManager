package com.breedmanager.services;

import com.breedmanager.DTO.MessageDTO;
import com.breedmanager.entitis.Message;
import com.breedmanager.entitis.User;
import com.breedmanager.repositories.MessageRepository;
import com.breedmanager.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {

    private MessageRepository messageRepository;

    public MessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    public void sendMessage(MessageDTO messageDTO){
        Message message = new Message();
        message.setSender(messageDTO.getSender());
        message.setReceiver(messageDTO.getReceiver());
        message.setMessage(messageDTO.getMessage());
        messageRepository.save(message);
    }

    public List<Message> findAllByReceiver(User user){
        return messageRepository.findMessagesByReceiver(user);
    }
    public List<Message> findAllBySender(User user){
        return messageRepository.findMessagesBySender(user);
    }
}
