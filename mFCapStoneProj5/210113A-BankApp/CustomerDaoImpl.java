package com.cp5;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerDaoImpl implements CustomerDao {
	
	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public List<Customer> getAllCustomers() {
//		customerRepository.findAll();
		return null;
	}

	
	
	
	
}
