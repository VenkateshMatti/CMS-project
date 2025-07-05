  package com.example.scholarSync.config;

   

  import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Bean;
  import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
  import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
  import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
  import org.springframework.security.crypto.password.PasswordEncoder;
  import org.springframework.security.web.SecurityFilterChain;

import com.example.scholarSync.impl.CustomUserDetailsService;

  @Configuration
  @EnableWebSecurity
  public class WebSecurityConfig {

	  @Autowired
	  private  CustomUserDetailsService customUserDetailsService;
	  
      @Bean
      public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
          http
              .authorizeHttpRequests(auth -> auth
                  .requestMatchers("/login", "/register", "/css/**", "/js/**", "/images/**","/webjars/**").permitAll() // Allow access to login and register pages
                  .requestMatchers(
                          "/my-courses/**",
                          "/profile",
                          "/messages",
                          "/feedback"
                      ).authenticated() // Require login
                      .anyRequest().permitAll()
              )
              .formLogin(form -> form
                  .loginPage("/login")
                  .defaultSuccessUrl("/home", true) 
                  .permitAll()
              )
              .logout(logout -> logout
            		    .logoutUrl("/logout")                     // Endpoint to call to logout
            		    .logoutSuccessUrl("/login?logout")       // Redirect after logout
            		    .invalidateHttpSession(true)             // Invalidate session
            		    .deleteCookies("JSESSIONID")             // Clear session cookies
            		    .permitAll()
            		);


          return http.build();
      }

      @Bean
      public PasswordEncoder passwordEncoder() {
          return new BCryptPasswordEncoder();
      }
      
      @Bean
      public AuthenticationManager authenticationManager(
          AuthenticationConfiguration config) throws Exception {
          return config.getAuthenticationManager();
      }
  }
