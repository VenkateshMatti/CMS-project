package com.example.scholarSync.controller;

 
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.example.scholarSync.Model.ContactMessage;
import com.example.scholarSync.Model.Course;
import com.example.scholarSync.repository.CourseRepository;
@Controller
public class HomeController {
	@Autowired
    private CourseRepository courseRepository;
	

    @GetMapping("/")
    public String root() {
        return "redirect:/home";
    }
    @GetMapping("/home")
    public String home(Model model) {
    	List<Course> courses = courseRepository.findAll();
        model.addAttribute("courses", courses);
        model.addAttribute("contact", new ContactMessage()); 
        return "home"; // or your main landing page template
    }

    @GetMapping("/about")
    public String about() {
        return "about"; // this will show about.html from templates
    }

    
 
}
