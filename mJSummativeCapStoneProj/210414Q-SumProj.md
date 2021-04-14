## Number Format
` [[${#numbers.formatDecimal( 9999 ,1,'COMMA',2,'POINT')}]]`

ref: https://www.baeldung.com/spring-thymeleaf-currencies

ref: https://www.thymeleaf.org/apidocs/thymeleaf/2.0.2/org/thymeleaf/expression/Numbers.html

#### invoice.html
``` html
	<div class="form-row">
		<h3 class="form-group col-md-12">Invoice Details</h3>
		<h5 class="form-group col-md-12">Reservation Charges No.: [[${inv.hireId}]]</h5>
		<div class="form-group col-md-8">
			<label>
				Total Time Charge at Daily Rate: [[${#numbers.formatCurrency( inv.rated )}]]
			</label> 
		</div>
		<div class="form-group col-md-4">
			<label>
				Sub Total: [[${#numbers.formatCurrency( inv.invPaymt.amount )}]]
			</label>
		</div>								
	</div>
	<div class="form-row">
		<div class="form-group col-md-8"></div>
		<div class="form-group col-md-4">
			<label>
				<b>Total Due: [[${#numbers.formatCurrency( inv.invPaymt.amount )}]] </b>
			</label>
		</div>
	</div>
```
