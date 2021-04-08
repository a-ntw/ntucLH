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
---
### ArrayList and print
#### dash.java
``` java
	List<ResPVeh> rlist = new ArrayList<>();
	rlist.add(new ResPVeh(33,333));
	rlist.add(new ResPVeh(66,999));
	rlist.add(new ResPVeh(22,222));

	for (ResPVeh item : rlist) {
		System.out.println("Item: " + item);
	}

	Stream.of(rlist).forEach(s -> System.out.println("::: " + s));
```
#### ResPVeh.java
``` java
public class ResPVeh {
	private int vehId;
	private int reserves;
	public ResPVeh(int i, int j) {
		this.vehId = i;
		this.reserves = j;
	}
	...
```
---
