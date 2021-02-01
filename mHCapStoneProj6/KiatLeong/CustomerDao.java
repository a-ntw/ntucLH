package com.cp5;

import java.util.List;

import org.springframework.data.domain.Page;

public interface CustomerDao {	
	public List<Customer> getAllCustomers(String keyword);
	public void saveCustomer(Customer customer);
	public Customer getCustomerById(long custId);
	public void deleteCustomerById(long custId);
	public Page<Customer> findPageinated(int pageNo, int pageSize, String keyword, String sortField, String sortDirection);
}
