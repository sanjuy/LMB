package com.gtbsa.LMS.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gtbsa.LMS.entities.BookEntity;
import com.gtbsa.LMS.repositories.BookRepository;

@Service
public class BookService {
    
    @Autowired
    private BookRepository bookRepo;

    public BookEntity saveBook(BookEntity book) {
        bookRepo.save(book);
        return book;
    }

    public List<BookEntity> getAllBooks() {
        return bookRepo.findAll();
    }
}
