### Snippet

#### EmployeeDaoImpl.java
``` java
@Service
public class EmployeeDaoImpl implements EmployeeDao{
	
	@Autowired
	private EmployeeRepo employeeRepo;
	
	@Override
	public List<Employee> getAllEmployees() {

		List <Employee> list = employeeRepo.findAll();
//		System.out.println("***** Employee List Size  " + list.size() );
		return list;
	}

	@Override
	public Employee getEmployeeById(long empId) {
		
		Optional <Employee> optional = employeeRepo.findById(empId);
		Employee customer = null;
		
		if(optional.isPresent())
			customer = optional.get();
		else
			throw new RuntimeException(" Employee not found for id :: " + empId);
		
		return customer;		
	}
	
	@Override
	public void save(Employee employee) {
		employeeRepo.save(employee);
	}
```
