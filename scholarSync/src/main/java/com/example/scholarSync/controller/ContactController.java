package com.example.scholarSync.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.scholarSync.Model.ContactMessage;
import com.example.scholarSync.repository.ContactMessageRepository;
import com.example.scholarSync.repository.CourseRepository;

@Controller
public class ContactController {

    @Autowired
    private ContactMessageRepository messageRepository;
    
	@Autowired
    private CourseRepository courseRepository;

    @GetMapping("/contact")
    public String showContactForm(Model model) {
        model.addAttribute("contact", new ContactMessage());
        return "contact";
    }

    @PostMapping("/contact")
    public String submitContactForm(@ModelAttribute ContactMessage contact, Model model) {
    	 ContactMessage test = new ContactMessage();
         test.setName("Test User");
         test.setEmail("test@example.com");
         test.setPhone("9999999999");
         test.setMessage("Testing save method.");
         messageRepository.save(test); // If this line gives error, something is wrong with the setup
    	
    	messageRepository.save(contact);
        model.addAttribute("success", "Thank you! Your message has been sent.");
        model.addAttribute("contact", new ContactMessage()); // reset form
        model.addAttribute("courses", courseRepository.findAll());
        return "home";
    }
    
}