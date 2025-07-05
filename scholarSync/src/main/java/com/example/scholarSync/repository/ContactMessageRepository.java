package com.example.scholarSync.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.scholarSync.Model.ContactMessage;
@Repository
public interface ContactMessageRepository  extends JpaRepository<ContactMessage, Long> {

}
