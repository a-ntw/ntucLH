## Snippet 

objects into an object
#### InvController.java
``` java
        	
    	Invoice inv = invoiceDao.getInvoiceById(invId);
    	InvCust invCust = new InvCust();
    	invCust.setInvoice(inv);
        	
    	log.warn("=====> /inv/export/pdf/> pdf: " + headerValue);
         
		UserPDFExporter exporter = new UserPDFExporter(invCust);
		exporter.export(response);
    }
    
	public  class InvCust {
		private Invoice inv;
		public Invoice getInv() {
			return inv;
		}
		public void setInvoice(Invoice inv) {
			this.inv = inv;
		}
		public Customer getCust() {
			Customer cust = new Customer();
			cust = custDao.getCustomerById(inv.getCustId());
			return cust;
		}
	}
```
#### UserPDFExporter.java
``` java
		Paragraph p3 = new Paragraph("Date: " + invCust.getInv().getDated());
		document.add(p3);
		p3 = new Paragraph("Customer's ID: " + invCust.getInv().getCustId()
				+ "\n" + invCust.getCust().getCustName()
				+ "\n" + invCust.getCust().getAddr1()
				+ "\n" + invCust.getCust().getAddr2()
				+ "\n" + invCust.getCust().getCity() );
		p3.setSpacingBefore(18);
		document.add(p3);
```
