package com.cp6.cust;

import java.util.List;

import org.springframework.data.domain.Page;

public interface CustomerDao {
	public List<Customer> getAllCustomers();

	public void saveCustomer(Customer customer);

	public Customer getCustomerById(long custId);

	public void deleteCustomerById(long custId);

//	public Page <Customer> findPageinated(int pageNo, int pageSize);
	public Page<Customer> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);
}
