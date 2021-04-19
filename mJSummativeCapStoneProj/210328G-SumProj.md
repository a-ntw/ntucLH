### Thymeleaf model.addAttribute, href Mapping
#### editHistory
BookingControl.java
``` java
	@GetMapping("/histEdit/{id}")
	public String historyEdit(@PathVariable(value = "id") long id, Model model) {
		History hist = historyRepo.findById(id).get();
		model.addAttribute("hist", hist);
		return "book/historyEdit";
	}
	@PostMapping("/histSave")
	public String saveHist(History hist) {
		historyRepo.save(hist);
		log.info("=====> History Saved. id:" + hist.getId() + " " + hist.getRecorded() );
		return "redirect:/histEdit/" + hist.getId() ;
	}
```
historyEdit.html
``` html
	<form th:action="@{/histSave}" th:object="${hist}" method="post">
		<div>
			<label> id: [[${hist.id}]] </label>
			<input type="hidden"  th:field="*{id}" th:value="${hist.id}"  /> 
		</div>


		<div>
			<label> recorded: [[${hist.recorded}]]</label>
			<input type="text" th:field="*{recorded}" required/>
		</div>		
		
		<button type="submit">Save</button>
	 	<a class="btn btn-primary" href="/histData" role="button">Cancel</a>				
	</form>
```

---
#### the start 
EmployeeController.java
``` java
@Controller
public class EmployeeController {
	@Autowired
	private EmployeeDao employeeDao;
	@Autowired
	private RoleRepo rolerepo;
  
	@GetMapping("/emp")
	public String viewEmpPage(Model model) {
		List<Role> roles = rolerepo.findAll();
		model.addAttribute("roles", roles);
		model.addAttribute("listEmps", employeeDao.getAllEmployees());
		return "emp/employees";
	}
```

employees.html
``` html
	<nav class="nav nav-tabs justify-content-end">
		<a class="nav-link" href="/emp/new">Create New Employee</a> </nav>

 	<table class="table table-striped">
		<thead>
			<tr>
			 	<th>ID</th> <th>User Name</th> <th>Role Type</th>
				<th>Email</th> <th>Active</th> <th>Actions</th>	
		</thead>	
		<tbody>
			<tr th:each="emp : ${listEmps}">
 				<td>[[ ${emp.empId} ]]</td> <td>[[ ${emp.empName} ]]</td>
				<td>[[ ${emp.roles} ]]</td> <td>[[ ${emp.email} ]]</td>
                                <!-- <td th:text="${emp.email}"/> -->
				<td>[[ ${emp.isActive} ]]</td>
				<td > <a th:href="@{'/emp/prf/' + ${emp.empId}}">Profile </a> </td>
			</tr>
		</tbody>
	</table> 
```

#### ModelAndView
EmployeeController.java
``` java
	@GetMapping("/emp/prf/{empId}")
	public ModelAndView profileEmployee(@PathVariable(value = "empId") long empId) {
		ModelAndView mav = new ModelAndView("emp/employeeProfile");	
		Employee emp = employeeDao.getEmployeeById(empId);
		mav.addObject("employee", emp);		
		List<Role> roles = rolerepo.findAll();
		mav.addObject("roles", roles);
		return mav;
	}
```

employeeProfile.html
``` html
	<form th:object="${employee}">
	<div class="form-row form-group col-md-6">
			<label>Employee ID: [[ ${empId} ]]</label>
	</div>
	
	<div class="form-row">
		<div class="form-group col-md-6">
			<label>User Name: </label>
			<input class="form-control" type="text" th:field="*{empName}" readonly/>
		</div>
		
		<div class="form-group col-md-6">
			<label>Roles</label>
			<div class="form-check form-check-inline" th:block th:each="roles : ${roles}">
				<input type="checkbox" disabled th:field="*{roles}" th:text="${roles.name}"
					th:value="${roles.roleId}"  readonly/>
			</div>
		</div>
    ...
```

#### @PathVariable("custId")
CustollerController.java
``` java
@Controller
public class CustomerController {
	@GetMapping("/cust/prf/{custId}")
	public String profileCustomer(@PathVariable("custId") Long custId, Model model) {
		Customer cust = customerDao.getCustomerById(custId);
		model.addAttribute("customer", cust);
		List<CustState> listCustStates = stateRepo.findAll();
		model.addAttribute("listCustStates", listCustStates);
		return "cust/customerProfile";
	}
```

customerProfile.html
``` html
	<nav class="nav nav-tabs justify-content-end">
		<a class="nav-link" href="/cust">Back</a>
		<a class="nav-link" th:href="@{'/cust/edit/' + ${custId}}">Edit</a>
		<!-- <a class="nav-link" th:href="@{'/cust/delete/' + ${custId}}">Delete</a> -->
		<a class="nav-link" data-toggle="modal" data-target="#doubleConfirm" style="color: #17a2b8">Delete</a>
	</nav>

	<form th:object="${customer}">
	
	<div class="form-row">
		<div class="form-group col-md-6">
				<label>Customer ID: [[ ${custId} ]]</label>
		</div>
		<div class="form-group col-md-6">
				<label>Date Updated: 
				<input type="date" th:field="*{dateUpd}" readonly/>
				</label>
		</div>
	</div>
	
	<div class="form-row">
		<div class="form-group col-md-6">
			<label>User Name: </label>
			<input class="form-control" type="text" th:field="*{custName}" readonly/>
		</div>
```

#### @ModelAttribute("booking") Booking booking
BookingControl.java
``` java
	@PostMapping(value = "/book/cnfm")
	public String bookConfirm(@ModelAttribute("booking") Booking booking, BindingResult bindingResult, Model model) {
		if(bindingResult.hasErrors())
			return "book/bookVeh";
		
		model.addAttribute("dayRate", calDayRateByBooking(booking));
		return "book/bookConfirm";
	}
```

bookConfirm.html
``` html
	<form action="#" th:action="@{/book/save}" th:object="${booking}" method="POST">
	<!-- <form th:object="${booking}"> -->

	<div class="form-row">
		<div class="form-group col-md-12">
				<label>Customer: [[${booking.customer.custName}]]  </label>
				<input type="text" th:field="*{customer}" readonly="readonly" hidden/>
		</div>
	</div>
 		<button class="btn btn-primary"  type="submit">Confirm</button>
 		<a class="btn btn-primary" href="/" role="button">Cancel</a>
 		<hr>
		<div class="form-group col-md-6">
	</div>
```

#### @Valid @ModelAttribute("hire") 
HireController.java
``` java
	@GetMapping("/hireEdit/{hireId}")
	public String editHireForm(@PathVariable(value = "hireId") long hireId, Model model) {
		Hires hire = hireDao.getHireById(hireId);
		model.addAttribute("hire", hire);
		List<Customer> customers = custDao.getAllCustomers();
		model.addAttribute("customers", customers);
		List<Vehicle> vehicles = vehDao.getAllVehicles();
		model.addAttribute("vehicles", vehicles);
		return "hire/hireEdit";
	}	
	
	@PostMapping(value = "/hire/save")
	public String saveEmp(@Valid @ModelAttribute("hire") Hires hire, BindingResult bindingResult) {
		if(bindingResult.hasErrors())
			return "hire/hireNew";

		hireDao.save(hire);
		return "redirect:/hire";
	}
  ```
  
  hireEdit.html
  ``` html
  <form action="#" th:action="@{/hire/save}" th:object="${hire}" method="POST">
	<div class="form-row form-group col-md-6">
			<label>Hire ID: </label>
			<input type="text" th:field="*{hireId}" readonly="readonly"/>
	</div>
	
	<div class="form-row">
 		<div class="form-group col-md-6">
			<label>Customer</label>
			<select th:field="*{customer}" class="form-control" required>
				<th:block th:each="cust : ${customers}">
					<option th:text="'[' + ${cust.custId} + '] ' + ${cust.custName}" 
					th:value="${cust.custId}" required/>
				</th:block>
			</select>
		</div>
    ...

	</div>
	 		<button class="btn btn-primary"  type="submit">Save</button>
 		<a class="btn btn-primary" href="/hire" role="button">Cancel</a>
```
