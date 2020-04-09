package com.breedmanager.services;

import com.breedmanager.DTO.MessageDTO;
import com.breedmanager.entitis.Message;
import com.breedmanager.entitis.User;
import com.breedmanager.interfaces.MessageInterface;
import com.breedmanager.repositories.MessageRepository;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@CacheConfig(cacheNames = {"messageCache"})
public class MessageService implements MessageInterface {

    private MessageRepository messageRepository;
    private RabbitTemplate template;
    private Queue queue = new Queue("surpriseMTFC");


    @Autowired
    public MessageService(MessageRepository messageRepository, RabbitTemplate template) {
        this.messageRepository = messageRepository;
        this.template = template;
    }

    public void sendMessage(MessageDTO messageDTO) {
        Message message = new Message();
        message.setSender(messageDTO.getSender());
        message.setReceiver(messageDTO.getReceiver());
        message.setMessage(messageDTO.getMessage());
        template.convertAndSend(messageDTO.getMessage(), queue.getName());
        messageRepository.save(message );
    }

    @Cacheable
    public List<Message> findAllByReceiver(User user) {
        return messageRepository.findMessagesByReceiver(user);
    }

    @Cacheable
    public List<Message> findAllBySender(User user) {
        return messageRepository.findMessagesBySender(user);
    }
}
