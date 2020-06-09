package com.example.demo.repository;

import java.util.List;

import com.example.demo.entities.Customer;
import com.example.demo.entities.Expenses;
import com.example.demo.entities.ExternalRequest;
import com.example.demo.entities.InternalRequest;
import com.example.demo.entities.Project;
import com.example.demo.entities.Ticket;
import com.example.demo.entities.Users;

public interface IndexRepository {
	public List<Customer> findByVip(String vip);
	public List<Ticket> findByStatusTicket(String status);
	public List<Users> findByIsCustomer(Boolean isCustomer);
	public List<Project> findByStatusP(String status);
	public List<Expenses> findByStatutExpense(String statutExpense);
	public List<ExternalRequest> findByStatus(Boolean stat);
	public List<InternalRequest> findByStatus(String status);
}
