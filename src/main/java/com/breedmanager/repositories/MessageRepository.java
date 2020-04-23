package com.breedmanager.repositories;

import com.breedmanager.model.Message;
import com.breedmanager.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {
    List<Message> findMessagesByReceiver(User receiver);
    List<Message> findMessagesBySender(User sender);
}
