package com.example.scholarSync.controller;

 


import org.springframework.stereotype.Controller;
 
import org.springframework.web.bind.annotation.GetMapping;

 

@Controller
public class ProfileController {

	 
	
	@GetMapping("/feedback")
	public String showFeedbackPage() {
	    return "feedback"; // feedback.html
	}

	@GetMapping("/messages")
	public String showMessagesPage() {
	    return "messages"; // messages.html
	}
	 
    
}
