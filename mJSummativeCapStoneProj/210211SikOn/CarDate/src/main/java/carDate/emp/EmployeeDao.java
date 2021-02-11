package carDate.emp;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

@Component
public interface EmployeeDao {

	public List<Employee> getAllEmployees();
	public void saveEmployee(Employee employee);
	public Employee getEmployeeById(long empId);
	public Employee getEmployeeByEmpName(String empName);
	public void deleteEmployeeById(long empId);
	public Page<Employee> empPaginated(int pageNo, int pageSize, String sortField, String sortDirection); 


}
