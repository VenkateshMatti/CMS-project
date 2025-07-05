package com.example.scholarSync.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.scholarSync.Model.courses;

public interface coursesRepository extends JpaRepository<courses, Long> {
    List<courses> findByUserUsername(String username);
}