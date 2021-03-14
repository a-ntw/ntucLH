### Debug snippets

#### bindingResult
CustomerController.java
``` java
...
	@PostMapping(value = "/cust/save")
	public String saveCustomer(@Valid @ModelAttribute("customer") Customer cust, BindingResult bindingResult) {

		if(bindingResult.hasErrors()) {
			log.warn("=====> CustromerController > saveCustomer, bindingResult.getAllErrors():: " 
						+ bindingResult.getAllErrors());
			return "cust/customerNew";
		}

		customerDao.save(cust);
		
		log.info("=====> CustromerController > saveCustomer, custId: " + cust.getCustId());
		return "redirect:/cust";
	}

...
```
