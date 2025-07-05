package com.example.scholarSync.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class courses {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	 private String title;
    private String dateRange;
    private int progress;
    
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    
    public courses() {}
    
	public courses(String title, String dateRange, int progress) {
		 
		this.title = title;
		this.dateRange = dateRange;
		this.progress = progress;
	}

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDateRange() {
		return dateRange;
	}

	public void setDateRange(String dateRange) {
		this.dateRange = dateRange;
	}

	public int getProgress() {
		return progress;
	}

	public void setProgress(int progress) {
		this.progress = progress;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	 
    
}
