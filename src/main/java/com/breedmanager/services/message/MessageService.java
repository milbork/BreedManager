package com.breedmanager.services.message;

import com.breedmanager.model.DTO.MessageDTO;
import com.breedmanager.model.Message;
import com.breedmanager.model.User;

import java.util.List;

public interface MessageService {

    void sendMessage(MessageDTO messageDTO);
    List<Message> findAllByReceiver(User user);
    List<Message> findAllBySender(User user);
}

