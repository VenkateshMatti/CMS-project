package com.example.scholarSync.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.scholarSync.Model.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
	 List<Course> findByType(String type);

	    // 🔍 Find courses where title contains a keyword (case-insensitive)
	    List<Course> findByTitleContainingIgnoreCase(String keyword);

	    // 🔍 Get courses with discount price less than a value
	    List<Course> findByDiscountedPriceLessThan(double price);

	    // 🔍 Sort courses by discounted price ascending
	    List<Course> findAllByOrderByDiscountedPriceAsc();

	    // 🔍 Sort courses by discounted price descending
	    List<Course> findAllByOrderByDiscountedPriceDesc();
}
