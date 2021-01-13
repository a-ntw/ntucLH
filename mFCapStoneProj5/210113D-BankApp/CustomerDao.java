package com.cp5;

import java.util.List;

public interface CustomerDao {
	public List<Customer> getAllCustomers();
	public void saveCustomer(Customer customer);
	public Customer getCustomerById(long custId);
	public void deleteCustomerById(long custId);
}
