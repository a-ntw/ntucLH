### Date Picker with dates
210318DatesBlocks.png <img src="210318DatesBlocks.png">

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
</head> 

<body> 
	<center> 
		<h1>Disable Booked dates</h1> 
		<h4>Using jQuery UI beforeShowDay</h4>
		<h3>Shown blocked dated on 13 April and 14 April</h3>
	Start Date: 
	<input type="text" id="my_date_picker1"> 
	<script th:inline="javascript">
		$(document).ready(function() { 

			var cdate = new Date();
			
			var my_array = [];
			my_array = new Array('4/4/2021','13/4/2021','28/3/2021');
			
				/*<![CDATA[*/
			   	/*[# th:each="n : ${finalDates}"]*/
				my_array.push("[(${n})]");
				/*[/]*/
								
			$(function() { 
				$("#my_date_picker1").datepicker({ 
					dateFormat: 'yy-mm-dd', 
					//dateFormat: 'dd-mm-yy', 
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

#### JsController.java
``` java
package com.ntuc;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class JsController {

	@GetMapping("/")
	public String showMain(Model model) {

		model.addAttribute("finalDates", finalDates());

		return "index";
	}

	public String[] finalDates() {
		
		LocalDate[] listdates = new LocalDate[3];				// size up first
		LocalDate abcDate1 = LocalDate.parse("2021-04-20");
		LocalDate abcDate2 = LocalDate.parse("2021-04-21");
		LocalDate abcDate3 = LocalDate.parse("2021-04-22");
		listdates[0] = abcDate1;
		listdates[1] = abcDate2;
		listdates[2] = abcDate3;

		
		String[] finalDates= new String[listdates.length];
	
		DateTimeFormatter dTF; 
		dTF = DateTimeFormatter.ofPattern("d/M/yyyy");

		for(int i=0;i<listdates.length;i++) {
			finalDates[i]=dTF.format(listdates[i]);
		}
		
		return finalDates;
		
	}
	
}

```


#### application.properties
serve no purpose
```
spring.datasource.url=jdbc:oracle:thin:@//localhost:1521/ORCL
spring.datasource.username=sridhar
spring.datasource.password=sridhar

#spring.jackson.date-format=dd/mm/yyyy
#spring.jackson.date-format=yyyy/mm/dd

spring.jpa.hibernate.ddl-auto=update
#logging.level.root=info
```