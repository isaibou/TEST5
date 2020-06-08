package com.example.demo.repository;

import java.util.Collection;
import java.util.List;

import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entities.Project;
import com.example.demo.entities.Ticket;
import com.example.demo.entities.Users;

public interface ProjetRepository extends JpaRepository<Project, Integer>{
	 
	
	
	
	@Query("select count(e)>0 from Project e where e.Name = ?1")
	Boolean checkTitleExist(String name);
	public List<Project> findByStatus(String status);  
	
	
	
	
	
	
	//public List<Project> findByStatusAndUser(
	//		  @Param("status") String status, 
		//	  @Param("user") Users user);
			
			// List<Ticket> findByStatusTicketNotIn(Collection<Ticket> status);
			
	
	// List<Project> findByStatusIn(String status,String name);
	 
	 
	
	
	//@Query("SELECT a FROM List a WHERE a.status = statusProject ")
	//List<Project> getAWithNoIntersectionInGroups(@Param("List")List<Project> l, @Param("statusProject") String s);
	
	// @Query("SELECT u FROM User u WHERE u.status = :status and u.name = :name")
	 //User findUserByStatusAndNameNamedParams(
	   //@Param("status") Integer status, 
	   //@Param("name") String name);
	 
//	 @Query("SELECT u FROM :list u WHERE u.status = :status ")
	// Project findUserByStatuAndNameNamedParams(
	  // @Param("list") List<Project> project, 
	   //@Param("status") String name);
	 
	 
	 
	 
	 
	 
	
	 
}
