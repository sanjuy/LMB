package com.gtbsa.LMS.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gtbsa.LMS.entities.BookEntity;

public interface BookRepository extends JpaRepository<BookEntity, Integer>{
    
}
