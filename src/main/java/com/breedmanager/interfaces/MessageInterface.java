package com.breedmanager.interfaces;

import com.breedmanager.DTO.MessageDTO;
import com.breedmanager.entitis.Message;
import com.breedmanager.entitis.User;

import java.util.List;

public interface MessageInterface {

    void sendMessage(MessageDTO messageDTO);
    List<Message> findAllByReceiver(User user);
    List<Message> findAllBySender(User user);
}

