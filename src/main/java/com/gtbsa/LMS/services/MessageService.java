package com.gtbsa.LMS.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gtbsa.LMS.entities.Message;
import com.gtbsa.LMS.repositories.MessageRepository;

@Service
public class MessageService {

    @Autowired
    private MessageRepository messageRepo;

    public Message saveMessage(Message message) {
        messageRepo.save(message);
        return message;
    }

    public List<Message> getMessages() {
        return messageRepo.findAll();
    }



}
