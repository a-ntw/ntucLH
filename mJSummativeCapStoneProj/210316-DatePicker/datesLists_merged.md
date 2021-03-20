### Date Picker with dates
210319DatesBlocks.png <img src="210319DatesBlocks.png">


#### JsController.java
``` java
package com.ntuc;

import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class JsController {

	@GetMapping("/")
	public String showMain(Model model) {

		List<Blockdate> listBddates = null;
		String[] fdates = calenderBlkDates.fdates(listBddates);
		
		model.addAttribute("calenderBlkDates", fdates); // finalDates can only add once

		return "index";
	}

}
```

#### calenderBlkDates.java
``` java
package com.ntuc;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class calenderBlkDates {

	// Array of Blockdates with Localdate startDate and Integer period
	public static String[] fdates(List<Blockdate> listBddates) {
		
		LocalDate abcDate2 = LocalDate.parse("2021-04-20");
		LocalDate[] listdates1;
		listdates1 = dateRange(abcDate2, 3);
		LocalDate abcDate3 = LocalDate.parse("2021-03-22");
		LocalDate[] listdates3;
		listdates3 = dateRange(abcDate3, 3);

		LocalDate[] mergedates = mergeDates(listdates1, listdates3 );

		return  finalDates(mergedates);
	}
	
	public static LocalDate[] mergeDates(LocalDate[] listA, LocalDate[] listB) {
		int length = listA.length + listB.length;
		LocalDate[] mergedates = new LocalDate[length];
		int pos =0;
		for (LocalDate element : listA)
		{ mergedates[pos] = element; pos ++;}
		for (LocalDate element : listB)
		{ mergedates[pos] = element; pos ++;}
		//Stream.of(mergedates).forEach(s -> System.out.println("Stream :: " + s));
		
		return mergedates;
	}

	
	public static <T> Object[] mergeArray(T[] arr1, T[] arr2)   
	{   
		return Stream.of(arr1, arr2).flatMap(Stream::of).toArray();   
	}   

	public static LocalDate[] dateRange(LocalDate start, Integer daysNo) {
		LocalDate[] dateRange = new LocalDate[daysNo];
		for(int i=0;i<daysNo;i++) {
			dateRange[i] = start.plusDays(i);
			//System.out.println("=====> dateRange: " + dateRange[i] );
		}
		
		return dateRange;
	}
	
	public static String[] finalDates(LocalDate[] listdates) {
		
		String[] finalDates= new String[listdates.length]; // size up first
	
		DateTimeFormatter dTF; 
		dTF = DateTimeFormatter.ofPattern("d/M/yyyy");

		for(int i=0;i<listdates.length;i++) {
			finalDates[i]=dTF.format(listdates[i]);
			//System.out.println("=====> finalDates: " + finalDates[i]);
		}

		return finalDates;
		
	}
	

    //Stream of dates with 1 day difference
    public static List<LocalDate> getDaysInJava8(LocalDate start, int days) 
    {
        return Stream.iterate(start, date -> date.plusDays(1))
                .limit(days)
                .collect(Collectors.toList());
    }
    
}
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
			//my_array = new Array('4/4/2021','13/4/2021','28/3/2021');
			
				/*<![CDATA[*/
			   	/*[# th:each="n : ${calenderBlkDates}"]*/
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

---
Others
#### Blockdata.java
``` java
@Entity
@Table(name="booked_dates")
@Component
public class Blockdate {
	
	@Id
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private LocalDate bdate;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate edate;
	
	
	public Blockdate() {
		super();
	}

	public LocalDate getBdate() {
		return bdate;
	}

	public void setBdate(LocalDate bdate) {
		this.bdate = bdate;
	}

	public LocalDate getEdate() {
		return edate;
	}

	public void setEdate(LocalDate edate) {
		this.edate = edate;
	}

	@Override
	public String toString() {
		return "Blockdate [bdate=" + bdate + ", edate=" + edate + "]";
	}

}
```

#### bdatesRepository.java
``` java
public interface bdatesRepository extends JpaRepository<Blockdate, LocalDate> {

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