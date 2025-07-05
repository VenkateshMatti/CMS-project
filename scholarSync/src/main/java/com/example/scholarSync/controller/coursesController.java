package com.example.scholarSync.controller;

import java.security.Principal;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.scholarSync.Model.Update;
import com.example.scholarSync.Model.Video;
import com.example.scholarSync.Model.courses;
import com.example.scholarSync.Service.VideoService;
import com.example.scholarSync.Service.coursesService;


@Controller
public class coursesController {
	@Autowired
	private coursesService coursesService;
	 @Autowired
	    private VideoService videoService;
	@GetMapping("/my-courses")
	public String showCourses(Model model, Principal principal) {
		if (principal == null) {
	        return "redirect:/login"; // redirect to login if not authenticated
	    }

	    String username = principal.getName(); // Fetch logged-in username

        
	    
	    List<courses> courseList = coursesService.getCoursesForLoggedInUser(username);
	    System.out.println("COURSES: " + courseList.size());
	    model.addAttribute("courseList", courseList);
	    model.addAttribute("username", username);
	    
	 // Add dummy updates (you can replace this with real service call)
        List<Update> updates = List.of(
            new Update("Spring Boot Class", "Cancelled on 19-Apr-25 at 9:00 AM"),
            new Update("Spring Boot Class", "Cancelled on 5-Apr-25 at 9:00 AM")
        );
        model.addAttribute("updates", updates);
	    return "my-courses";
	}
	 @GetMapping("/add-course")
	    public String showCourseForm(Model model) {
	        model.addAttribute("course", new courses());
	        return "add-course"; // form page to add new course
	    }

	    @PostMapping("/save-course")
	    public String saveCourse(@ModelAttribute("course") courses course) {
	        coursesService.saveCourse(course);
	        return "redirect:/my-courses";
	    }

	    @GetMapping("/my-courses/{id}")
	    public String showCourseVideos(@PathVariable Long id, Model model) {
	        courses course = coursesService.getCourseById(id);
	        List<Video> videos = videoService.getVideosByCourseId(id);

	        model.addAttribute("course", course);
	        model.addAttribute("videos", videos);
	        return "course-videos";
	    }
}
