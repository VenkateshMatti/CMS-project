package com.example.scholarSync.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.scholarSync.Model.Video;
import com.example.scholarSync.repository.VideoRepository;

@Service
public class VideoService {
	 @Autowired
	    private VideoRepository videoRepository;

	    public List<Video> getVideosByCourseId(Long courseId) {
	        return videoRepository.findByCourseId(courseId);
	    }
}
