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
``` java
	int getYr = 21; int getMth = 3;
	String mEnum = getYr + "/" + String.format("%02d", getMth);
	System.out.println(mEnum);	// 21/03
	
	String mEnum2 = String.format("%.2f", 1.23456);
	System.out.println(mEnum2); 	// 1.23
```
## ThymeLeaf
### th:unless, th:if
210209D-SpringManyToMany/.../product_form.html
``` html
<th:block th:unless="${product.id == null}"  th:each ="detail, status : ${product.details}">
	<input type="hidden" name="detailID" th:value="${detail.id}" />
	<div class="form-group row">
		<label class="col-form-label col-sm-18"> Details #[[status.count]] : </label>
		<div class="col-sm-4">
			<input type="text" name="detailName"  th:value="${detail.name}"   class="form-control" required />
		</div>
		...
	</div>			
</th:block>

<th:block th:if="${product.id == null}">
<div class="form-group row">
		<label class="col-form-label col-sm-18"> Details #1 : </label>
		<div class="col-sm-4">
			<input type="text" name="detailName"  placeholder="Name"  step= "0.1" class="form-control" required />
		</div>
```

---
