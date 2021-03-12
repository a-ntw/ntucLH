package carDate.cust;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

//@Component
public interface CustomerDao {

	public List<Customer> getAllCustomers();
	public void saveCustomer(Customer customer);
	public Customer getCustomerById(long custId);
	public Customer getCustomerByCustName(String custName);
	public void deleteCustomerById(long custId);
	public Page <Customer> custPaginated(int pageNo, int pageSize, String keyword, String sortField, String sortDirection); 

}
