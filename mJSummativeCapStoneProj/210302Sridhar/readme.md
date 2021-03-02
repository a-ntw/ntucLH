Pick Date
===
[top]: topOfThePage



210302BookDates.png <img src="210302BookDates.png">

#### application.properties
``` 
spring.datasource.url=jdbc:oracle:thin:@//localhost:1521/ORCL
spring.datasource.username=sridhar
spring.datasource.password=sridhar

spring.jackson.date-format=dd/mm/yyyy

spring.jpa.hibernate.ddl-auto=update
logging.level.root=info
```

#### index.html
``` html
<!DOCTYPE html> 
<html xmlns:th="http://www.thymeleaf.org">
<head> 
	<link href= 
'https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/themes/ui-lightness/jquery-ui.css'
		rel='stylesheet'> 
	<script src= 
"https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"> 
	</script> 
	<script src= 
"https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.js"> 
		
	</script> 
	<style> 
		h1{ 
			color:blue; 
		} 
		.ui-datepicker { 
			width: 12em; 
		} 
	</style> 
</head> 

<body> 
	<center> 
		<h1>Disable Booked dates</h1> 
		<h4>Using jQuery UI beforeShowDay</h4> 
	Start Date: 
	<input type="text" id="my_date_picker1"> 
	<script th:inline="javascript">
		$(document).ready(function() { 

				var cdate = new Date();
			$(function() { 
				$("#my_date_picker1").datepicker({ 
					dateFormat: 'dd-mm-yy', 
					numberOfMonths:2,
					minDate: cdate,
					maxDate:60,
					defaultDate: cdate,
					beforeShowDay: my_check 

				}); 
			}); 

			function my_check(in_date) { 
				in_date = in_date.getDate() + '/' 
				+ (in_date.getMonth() + 1) + '/' + in_date.getFullYear(); 
				//var my_array = new Array('3/3/2021', '13/3/2021','13/4/2021','28/3/2021');
			
			
					var object = '[[${listdates}]]'
					var my_array = []
					
					my_array.push(object)
					//alert (my_array)
				
		
 
				if (my_array.indexOf(in_date) >= 0) { 
					return [false, "notav", 'Not Available']; 
				} else { 
					return [true, "av", "available"]; 
				}
			} 
		}) 
	</script> 

</body> 
</html> 
```

#### blockdates.java
``` java
@Entity
@Table(name="booked_dates")
@Component
public class blockdates {
	@Id
	@DateTimeFormat(pattern="dd-MM-yyyy")
	private Date bdate;

	public Date getBate() {
		return bdate;
	}

	public void setBdate(Date bdate) {
		this.bdate = bdate;
	}
}
```
#### bdatesRepository.java
``` java
public interface bdatesRepository extends JpaRepository<blockdates, Date> {

}
```
#### JsController.java
``` java
@Controller
public class JsController {

	@Autowired blockdates d;
	@Autowired bdatesRepository repo;
	@GetMapping("/")
	public String showMain(Model model) {
		List<blockdates> listdates = repo.findAll();
		listdates.toString();
		model.addAttribute("listdates", listdates);
		return "index";
	}
}
```

---
[:top: Top](#top)
