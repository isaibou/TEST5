package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.*;

public interface ChatRepository extends JpaRepository<Chat, Integer>{
	

}
