package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.*;

public interface UsersRepository extends JpaRepository<Users, Integer>{

}
