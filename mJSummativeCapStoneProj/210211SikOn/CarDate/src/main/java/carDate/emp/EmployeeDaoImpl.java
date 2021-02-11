package carDate.emp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class EmployeeDaoImpl implements EmployeeDao{

	@Autowired
	private EmployeeRepo employeeRepo;
	
	@Override
	
	public List<Employee> getAllEmployees() {
		return employeeRepo.findAll();
	}

	@Override
	public void saveEmployee(Employee employee) {
		employeeRepo.save(employee);
		
	}

	@Override
	public Employee getEmployeeById(long empId) {
		Optional <Employee> optional = employeeRepo.findById(empId);
		Employee employee = null;
		if (optional.isPresent())
			employee = optional.get();
		else
			throw new RuntimeException("Employee not found for id=" + empId);
		return employee;
	}

	@Override
	public void deleteEmployeeById(long empId) {
		employeeRepo.deleteById(empId);
		
	}

	@Override
	public Page<Employee> empPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
		Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending()
				: Sort.by(sortField).descending();
		Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort); // Note pageNo starts from 0, not 1, hence the -1.
		return employeeRepo.findAll(pageable);
	}

	@Override
	public Employee getEmployeeByEmpName(String empName) {
		Employee employee = employeeRepo.findByEmpName(empName);
		return employee;
	}

}
