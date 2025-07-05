 package com.example.scholarSync.Service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.scholarSync.Model.courses;
import com.example.scholarSync.repository.coursesRepository;

@Service
public class coursesService {

    @Autowired
    private coursesRepository courseRepository;

    public List<courses> getCoursesForLoggedInUser(String username) {
        return courseRepository.findByUserUsername(username);
    }
    public void saveCourse(courses course) {
        courseRepository.save(course);
    }
    public courses getCourseById(Long id) {
        return courseRepository.findById(id).orElse(null);
    }
}
