package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.entities.Customer;

@Service 
public class customerServiceImp implements customerService {

	@Override
	public boolean isCustomerNameAlreadyPresent(Customer customer) {
		
		return false;
	}

}
