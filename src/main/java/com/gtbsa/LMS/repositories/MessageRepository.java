package com.gtbsa.LMS.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gtbsa.LMS.entities.Message;

public interface MessageRepository extends JpaRepository<Message, Integer> {
    
}
