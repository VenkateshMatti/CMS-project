package com.example.scholarSync.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.scholarSync.Model.User;
import com.example.scholarSync.repository.UserRepository;

@Service
public class UserService {
	@Autowired
    private UserRepository userRepository;
	 @Autowired
	    private PasswordEncoder passwordEncoder;
	 public User registerUser(User user) {
	        // 🔒 Encode the password before saving
	        user.setPassword(passwordEncoder.encode(user.getPassword()));
	        return userRepository.save(user);
	    }
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
	
}
