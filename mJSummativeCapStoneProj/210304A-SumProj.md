### Transactional Testing with Dao, and Repo

#### empValidTest.java
``` java
package carDate.emp;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)    // for Dao testing 
@Transactional                  // for Dao testing
@SpringBootTest	                // for Dao testing
public class empValidTest {
	
	@Autowired
	private EmployeeRepo empRepo; 

	@Autowired
	private EmployeeDao empDao; 
	
	@Test
	public void empDaoGetAllEmpTest() {
		if (!empDao.getAllEmployees().isEmpty()) {
			List<Employee>  employees = empDao.getAllEmployees();
			assertThat(employees).isNotNull();
		}
	}

	
	/* Unable to run/test with DAO/Repo state 
	 * current test thru about.html/test */
	@Disabled
	@Test
	public void testDuplicateEmail() {
		EmpValid empValid = new EmpValid();
		assertTrue(empValid.duplicateEmail("ntuc@ntuc.com"));
		assertFalse(empValid.duplicateEmail("very@newEmail.com"));
	}
	
	/* test on empRepo.findAllEmail(email) */
	@Test
	public void testRepoFindEmail() {
		Employee emp = empRepo.findByEmail("ntuc@ntuc.com");
		assertEquals(emp.getEmpName(),"ntuc");
		assertEquals(emp.getPassword().length(), 60);
	}
	
	/* test on empRepo.findAllByEmail(email) */
	@Test
	public void testRepoFindAllEmail() {
		Employee[] empS = empRepo.findAllByEmail("ntuc@ntuc.com");
		assertEquals(empS.length, 1);
		empS = empRepo.findAllByEmail("noSuch@email.com");
		assertEquals(empS.length, 0);
	}

	/* test on empDao.getAllByEmail(email) 
	 * ref: https://dzone.com/articles/unit-testing-dao-service-and-controller-in-spring
	 * */
	@Test
	public void testDaoFindAllEmail() {
		Employee[] empS = empDao.getAllByEmail("ntuc@ntuc.com");
		assertThat(empS).isNotNull();
	}
}

```
#### EmpValid
this only can test thru html link
``` java
@Controller // for GetMapping
@Service	// defining a bean of this EmpValid
public class EmpValid  {

	@Autowired
	private EmployeeDao empDao;
	
	@GetMapping("/test")
	public String test() {
		System.out.println("=====> T E S T");
		duplicateEmail("ntuc@ntuc.com");
		duplicateEmail("very@newEmail.com");
		return "test";
	}

	/* Return True if there are such email found in database.
	 * planning to use to check duplicate email during new emp.
	 * */
	public Boolean duplicateEmail(String newEmail) {

		Employee[] empS = empDao.getAllByEmail(newEmail);
		System.out.println("=====>  duplicateEmail: " + empS.length);
		if (empS.length >= 1) {
			System.out.println("=====> YES, email is found ");
			return true; // Return to Employee New with alert
		} else {
			System.out.println("=====> FALSE, email is available."); // Return to save, and cont.
		}
		return false;
	}	

}
```
#### about.html
``` html
		<li>
		<!-- link to EmpValid-->
		<a th:href="@{/test}"> <h4>Test</h4> </a>
		</li>
```
#### EmployeeDao.java
``` java
@Component
public interface EmployeeDao {
	
	public List<Employee> getAllEmployees();
	public Employee getEmployeeById(long empId);
	public void save(Employee employee);
	public void delete(Long id);
	public Employee findByEmail(String email);
	public Employee[] getAllByEmail(String email);

}
```
#### EmployeeDaoImpl.java
``` java
	@Override
	public Employee findByEmail(String email) {
		return employeeRepo.findByEmail(email);
	}

	@Override
	public Employee[] getAllByEmail(String email) {
		// TODO Auto-generated method stub
		Employee[] list =  employeeRepo.findAllByEmail(email);
		return list;
	}
```
#### EmployeeRepo.java
``` java
@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Long>{
	Employee findByEmpName(String empName);
	Employee findByEmail(String email);
	Employee[] findAllByEmail(String email);
}

```
#### Employee.java
not used!!!
``` java
	public boolean loginIsValid() {
		// tough to check password, yet to find how to decode
		LocalDate today = LocalDate.now();
		
		if (this.pswdExpiry.isAfter(today) && this.userExpiry.isAfter(today)) {
			return true;
		} else {
			System.out.println("Check on password, Pswd/ExpiryDate is valid.");
			return false;
		}
	}
	
	public boolean emailIsValid(String useremail) {

		if (this.email.contentEquals(useremail)	) {
			return true;
		} else {
			System.out.println("email is NOT the same.");
			return false;
		}
	}

```

