package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entities.Project;
import com.example.demo.entities.Ticket;
import com.example.demo.entities.Users;

public interface TicketRepository extends JpaRepository<Ticket, Integer>{

	public List<Ticket> findByStatusTicket(String status);
	public List<Ticket> findByUser(Users user);
	
	@Query("SELECT u FROM Ticket u WHERE u.statusTicket = :status and u.user = :user")
	
	public List<Ticket> findByStatusAndUser(
	  @Param("status") Integer status, 
	  @Param("user") Users user);
	
	
}
