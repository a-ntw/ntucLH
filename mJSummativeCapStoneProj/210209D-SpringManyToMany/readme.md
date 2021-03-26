ManyToMany Delete Alert
===

210209DeleteAlert.png <img src="210209DeleteAlert.png">

Directory arrangement

### Delete Alert
- need bootstra link - `<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          rel="stylesheet">`
- `delBtn` - `<a class="btn btn-danger delBtn" th:href="@{'/products/delete/' + ${product.id}}"  > Delete </a>`
- modal - minimumly: 
``` html
	<div class="modal" id="deleteModal">
		<a data-dismiss="modal">Keep</a>
		<a href="" id="delRef">proceed </a>
	</div>
```
- javaScript
``` html
<script src="https://code.jquery.com/jquery-3.3.1.min.js" type="text/javascript"></script>
<script  src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" type="text/javascript"></script>
<script  src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" type="text/javascript"></script>
<script  src="../static/main.js" th:src="@{/main.js}"  type="text/javascript"></script>
```
- main.js - 
``` js
$(document).ready(function () {
	$('.table .delBtn').on('click',function(event) {
		event.preventDefault();
		var href = $(this).attr('href');
		
		$('#deleteModal #delRef').attr('href',href);
		$('#deleteModal').modal();	
	});
	});
```

---
#### products.java
``` java
...
		<div> 	<h1>Product List </h1> </div>
			<div class="p-2">
				<a class="h4" th:href="@{/products/new}">Create New Product</a>
			</div> 
			<div>
				<table class="table table-bordered" id="table">
						<thead class="thead-dark">
						<tr>
							<th> ID </th>
							<th> Name </th>
							<th> Price </th>
							<th> Category </th>
							<th> Details </th>
							<th> Actions </th>				
						</tr>
						</thead>
						<tbody>
							<th:block th:each="product : ${listProducts}">
								<tr> 
									<td> [[${product.id}]]</td>
									<td> [[${product.name}]]</td>
									<td> [[${product.price}]]</td>
									<td> [[${product.category.name}]]</td>
									<td> [[${product.details}]]</td>
									<td>
											<a th:href="@{'/products/edit/' + ${product.id}}"> Edit </a>
											 <a class="btn btn-danger delBtn" th:href="@{'/products/delete/' + ${product.id}}"  > Delete </a>
											 <!-- <a th:href="@{'/products/delete/' + ${product.id}}"  > Delete </a>  -->
									</td>
									
								</tr>
								
								<!-- <p class="visibility=hidden" id = "prname"> [[${product.name}]] </p>  -->
								
							</th:block>
						</tbody>
				</table>
			</div>
			
		</div>
		
		<div class="text-center m-3">
			<h5>Copyright &copy; NTUC Ltd.</h5>
		</div>
	</div>
	
	<!-- 210209 For "btn btn-danger delBtn"  -->
<div class="modal fade" id="deleteModal" data-backdrop="static" data-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="deleteModalLabel">Delete Record</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
		<p class="alert alert-danger">
		Do you want to delete <div id="main"> </div>
		</p>
		
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Keep</button>
        <a class="btn btn-danger" href="" id="delRef">proceed </a>
      </div>
    </div>
  </div>
</div>

<!-- <script src="https://code.jquery.com/jquery-3.3.1.min.js"
        type="text/javascript"></script>
<script  src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" type="text/javascript"></script>
<script  src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" type="text/javascript"></script>
 -->
 <script  src="../static/main.js" th:src="@{/main.js}"
        type="text/javascript"></script>
</body>

</html>
```

#### static/main.js
``` js
$(document).ready(function () {
	$('.table .delBtn').on('click',function(event) {
		event.preventDefault();
			var href = $(this).attr('href');

var table = document.getElementById("table"),rIndex,cIndex;
for(i=0; i<table.rows.length; i++)

	for (j=0;j<table.rows[i].cells.length; j++)
	{
		table.rows[i].cells[j].onclick = function()
		{
			rIndex = this.parentElement.rowIndex;
			var temp = table.rows[rIndex].cells[1].innerHTML;
			var divmain = document.getElementById("main");
			divmain.innerHTML = table.rows[rIndex].cells[1].innerHTML;

		}
	}

		$('#deleteModal #delRef').attr('href',href);
		$('#deleteModal').modal();
		
	});
	
	});
	
/**
	$('table.#deleteButton').on('click',function(event) {
		event.preventDefault();
		var href = $(this).attr('href');
		$('deleteModal #delRef').attr('href',href);
		$('#deleteModal').modal();
	});
	
});
dated: 210209

$(document).ready(function () {
	$('.table .delBtn').on('click',function(event) {
		event.preventDefault();
		var href = $(this).attr('href');

//var prname = document.getElementById("prname").innerText;
//document.getElementById("main").innerText=prname;

		$('#deleteModal #delRef').attr('href',href);
		$('#deleteModal').modal();
		
	});
	});
 */		
```


---
