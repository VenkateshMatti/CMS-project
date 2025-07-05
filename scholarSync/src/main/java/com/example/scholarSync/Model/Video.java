package com.example.scholarSync.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Video {

	 
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String fileName;
    private String path;
    @ManyToOne
    @JoinColumn(name = "course_id")
    private courses course;
    public Video(String title, String path) {
        this.title = title;
        this.path = path;
    }

    public String getTitle() { return title; }
    public String getPath() { return path; }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public courses getCourse() {
		return course;
	}

	public void setCourse(courses course) {
		this.course = course;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	 
    
    
	
}
