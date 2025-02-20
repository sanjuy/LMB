package com.gtbsa.LMS.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.gtbsa.LMS.entities.Login;
import com.gtbsa.LMS.entities.Message;
import com.gtbsa.LMS.services.MessageService;

import jakarta.validation.Valid;

@Controller
public class LoginController {

    @Autowired
    private MessageService messageService;
    
    @GetMapping("/")
    public String getHomepage(Model model) {
        model.addAttribute("title", "Home - Farma Software Solutions");
        model.addAttribute("messageData", new Message());
        return "index";
    }

    @GetMapping("/home")
    public String getHomepage1(Model model) {
        model.addAttribute("title", "Home - Farma Software Solutions");
        return "home";
    }

    @GetMapping("/vision")
    public String getVisionpage(Model model) {
        model.addAttribute("title", "Vision - Farma Software Solutions");
        return "vision";
    }
    

    @GetMapping("/login")
    public String getLogin(Model model) {
        model.addAttribute("loginData", new Login());
        // return "index";
        return "loginView";
    }
    
    @PostMapping("/process")
    public String getSuccess(@Valid @ModelAttribute("loginData") Login loginData, BindingResult result) {
        if (result.hasErrors()) {
            // System.out.println(result);
            return "loginView";
        }
        
        System.out.println(loginData);
        return "success";
    }
    
    @GetMapping("/registration")
    public String getMethodName() {
        return "registration";
    }
    

    @PostMapping("/send")
    public String sendMessage(@ModelAttribute("messageData") Message message) {
        messageService.saveMessage(message);
        return "index";
    }
    


}
