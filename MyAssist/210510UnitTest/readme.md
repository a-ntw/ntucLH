### Spring Boot Unit Test Simple Example
ref:  https://www.javainuse.com/spring/springboot_testcases

#### pom.xml
``` xml
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-test</artifactId>
			<scope>test</scope>
		</dependency>
```
#### How2Unittest.java
``` java
@SpringBootApplication
public class How2UnittestApplication {

	public static void main(String[] args) {
		SpringApplication.run(How2UnittestApplication.class, args);
	}
}
```
#### Employee.java
``` java
public class Employee {
	private String empId;
	private String name;
	private String designation;
	private double salary;

	public Employee() {
	}
	// getter, setter
```
#### TestController
``` java
@RestController
public class TestController {

	@RequestMapping(value = "/employee", method = RequestMethod.GET)
	public Employee firstPage() {

		Employee emp = new Employee();
		emp.setName("emp1");
		emp.setDesignation("manager");
		emp.setEmpId("1");
		emp.setSalary(3000);

		return emp;
	}
}
```
Go to localhost:8080/employee
``` console
{"empId":"1","name":"emp1","designation":"manager","salary":3000.0}
```

#### How2UnittestApplicationTests.java
``` java
@RunWith(SpringRunner.class)
@SpringBootTest
public class How2UnittestApplicationTests {

	@Test
	public void contextLoads() {
	}
}
```
#### TestWebApp.java
extend  the How2UnittestApplicationTests, and write this test case for the TestController.java

``` java
package assist;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

public class TestWebApp extends How2UnittestApplicationTests{
	@Autowired
	private WebApplicationContext webApplicationContext;

	private MockMvc mockMvc;

	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	@Test
	public void testEmployee() throws Exception {
		mockMvc.perform(get("/employee")).andExpect(status().isOk())
				.andExpect(content().contentType("application/json;charset=UTF-8"))
				.andExpect(jsonPath("$.name").value("emp1")).andExpect(jsonPath("$.designation").value("manager"))
				.andExpect(jsonPath("$.empId").value("1")).andExpect(jsonPath("$.salary").value(3000));

	}
}
```

---