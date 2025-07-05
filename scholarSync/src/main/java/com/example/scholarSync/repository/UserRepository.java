package com.example.scholarSync.repository;

import java.util.Optional;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.scholarSync.Model.User;

public interface UserRepository extends JpaRepository <User, Long> {
	User findByEmail(String email);
	 Optional<User> findByUsername(String username); 
}
 