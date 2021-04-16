### Snippet
* EmployeeDaoImpl.java
* ArrayList and print
* link to external Javascript for ThymeLeaf
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
### link to external Javascript for ThymeLeaf
#### index.html
``` html
	<script th:inline="javascript">
	        var real_dataVeh = /*[[${chartDataVeh}]]*/'noValue';
	        var real_dataCus = /*[[${chartDataCus}]]*/'noValue';
	</script>
	<script th:src="@{/assets/piechart.js}"></script>
```
#### AppSecurity.java
Optional to set ...`,"/assets/**").permitAll()`. Currently, work without add this.
``` java
	@Override
	protected void configure(HttpSecurity http) throws Exception {
	
		http
			.csrf().disable()
			.authorizeRequests()
			.antMatchers("/login","/css/**","/img/**","/assets/**").permitAll()
			.antMatchers("/").hasAnyAuthority("USER", "MANAGER", "ADMIN")
			.antMatchers("/book*/**")	.hasAnyAuthority("USER", "MANAGER")
```
####  piechart.js
``` js
	//var real_dataVeh = /*[[${chartDataVeh}]]*/'noValue';      
        //var real_dataCus = /*[[${chartDataCus}]]*/'noValue';
 
			alert(real_dataVeh); // for debugging
	
        $(document).ready(function() {
            google.charts.load('current', {
                packages : [ 'corechart', 'bar' ]
            });
            
            google.charts.setOnLoadCallback(drawPieChartCus);
            google.charts.setOnLoadCallback(drawPieChartVeh);
        });
        
        function drawPieChartCus() {
            var data = new google.visualization.DataTable();
```
--- 
