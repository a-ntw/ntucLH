package com.cp5;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerDaoImpl implements CustomerDao {
	
	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public List<Customer> getAllCustomers() {
//		customerRepository.findAll();
//		return null;
		
		List<Customer> list = customerRepository.findAll();
		System.out.println("********************************************");
		System.out.println("Customer List Size " + list.size());
		System.out.println("********************************************");
		return list;
		
	}

	
	@Override
	public void saveCustomer(Customer customer) {
		customerRepository.save(customer);
	}


	@Override
	public Customer getCustomerById(long custId) {
		
		Optional <Customer> optional = customerRepository.findById(custId);
		Customer customer = null;
		
		if(optional.isPresent())
			customer = optional.get();
		else
			throw new RuntimeException(" Customer not found for id :: " + custId);
		
		return customer;		
	}

	@Override
	public void deleteCustomerById(long custId) {
		// TODO Auto-generated method stub
		customerRepository.deleteById(custId);
	}
	

}
