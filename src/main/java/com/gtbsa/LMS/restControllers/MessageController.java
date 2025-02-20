package com.gtbsa.LMS.restControllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gtbsa.LMS.entities.Message;
import com.gtbsa.LMS.services.MessageService;



@RestController
@RequestMapping("/api/v2")
public class MessageController {
    
    @Autowired
    private MessageService messageService;


    @PostMapping("/messages")
    public ResponseEntity<?> postMessage(@RequestBody Message entity) {
        return ResponseEntity.ok(messageService.saveMessage(entity));
        }

        @GetMapping("/messages")
        public List<Message> getMessage() {
            return messageService.getMessages();
        }
        


}
