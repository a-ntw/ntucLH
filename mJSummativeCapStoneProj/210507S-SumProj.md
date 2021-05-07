### Exception Handling

##### CustomerController.java
``` java
 	@GetMapping("/cust/delete/{custId}")
	public String deleteCustomer(@PathVariable(name = "custId") Long custId) {
		try {
			customerDao.delete(custId);
			log.warn("=====> delete(custId): " + custId);
		} catch (Exception e) {
            System.out.println("Something went wrong, contact the admin..");
            log.warn("=====> delete(custId) => Something went wrong to: " + custId);
            log.error(e.toString());
            return "error";
		}
		
		return "redirect:/cust";
	}
```
##### error.html
``` html
	<div class="parent" >
		<h2>
			accessDeniedPage... There is an Error ....
		</h2>

		Please check the spelling or the value is correct... <br>
		or, for deleting, please check for constraint, <br> 
		or, for new entry, please check not the same as in database.

	</div>
```
