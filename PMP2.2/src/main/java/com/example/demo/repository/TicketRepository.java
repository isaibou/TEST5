package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Ticket;
import com.example.demo.entities.Users;

public interface TicketRepository extends JpaRepository<Ticket, Integer>{

	public List<Ticket> findByStatusTicket(String status);
	public List<Ticket> findByUser(Users user);
	
	
}
