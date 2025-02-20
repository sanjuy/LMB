package com.gtbsa.LMS.restControllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gtbsa.LMS.entities.BookEntity;
import com.gtbsa.LMS.services.BookService;



@RestController
@RequestMapping("/api/v2")
public class MyHomeController {
    
    @Autowired
    private BookService bookService;

    
    @PostMapping("/book")
    public ResponseEntity<?> addBook(@RequestBody BookEntity book) {
        
        if (book == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        bookService.saveBook(book);
        return ResponseEntity.status(HttpStatus.CREATED).body(book);
        // return ResponseEntity.of(Optional.of(book)).status(HttpStatus.CREATED).build();
    }
    

    @GetMapping("/book")
    public ResponseEntity<?> getBooks() {
        List<BookEntity> book = bookService.getAllBooks();
        if (book.size() <= 0){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(book);
    }
    
}
