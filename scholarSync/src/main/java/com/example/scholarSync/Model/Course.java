package com.example.scholarSync.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
	public class Course {
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    private String title;
	    private String description;
	    private String imagePath;
	    private double originalPrice;
	    private double discountedPrice;
	    private String type; // e.g., "Online Course"
		
	    
	    // Getters and Setters
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
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		public String getImagePath() {
			return imagePath;
		}
		public void setImagePath(String imagePath) {
			this.imagePath = imagePath;
		}
		public double getOriginalPrice() {
			return originalPrice;
		}
		public void setOriginalPrice(double originalPrice) {
			this.originalPrice = originalPrice;
		}
		public double getDiscountedPrice() {
			return discountedPrice;
		}
		public void setDiscountedPrice(double discountedPrice) {
			this.discountedPrice = discountedPrice;
		}
		public String getType() {
			return type;
		}
		public void setType(String type) {
			this.type = type;
		}

	    
	    
	}

