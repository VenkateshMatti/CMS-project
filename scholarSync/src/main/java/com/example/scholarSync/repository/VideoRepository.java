package com.example.scholarSync.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.scholarSync.Model.Video;

public interface VideoRepository  extends JpaRepository<Video, Long> {
	List<Video> findByCourseId(Long courseId);

}