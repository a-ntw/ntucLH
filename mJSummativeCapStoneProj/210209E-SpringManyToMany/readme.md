CommonHtml NavBar
===

Thymeleaf PageLayout

https://www.thymeleaf.org/doc/articles/layouts.html

210210CommonHtml.png <img src="210210CommonHtml.png">


#### pom.xml
``` xml
	<dependency>
		<groupId>nz.net.ultraq.thymeleaf</groupId>
		<artifactId>thymeleaf-layout-dialect</artifactId>
	</dependency>
    
		<dependency>
			<groupId> org.webjars </groupId>
			<artifactId> bootstrap </artifactId>
			<version> 4.3.1</version> 
		</dependency>
		
		<dependency>
			<groupId> org.webjars </groupId>
			<artifactId> webjars-locator-core</artifactId>
		</dependency>
		
```

#### nav.js
``` js
$(document).ready(function(){
  $(".dropdown-toggle").dropdown();
});
```

#### main.js
``` js
$(document).ready(function() {
	$('.table .delBtn').on('click', function(event) {
		event.preventDefault();
		var href = $(this).attr('href');

		var table = document.getElementById("table"), rIndex, cIndex;
		for (i = 0; i < table.rows.length; i++)

			for (j = 0; j < table.rows[i].cells.length; j++) {
				table.rows[i].cells[j].onclick = function() {
					rIndex = this.parentElement.rowIndex;
					var temp = table.rows[rIndex].cells[1].innerHTML;
					var divmain = document.getElementById("main");
					divmain.innerHTML = "do you want to delete the product  <b>" 
						+ table.rows[rIndex].cells[1].innerHTML + "</b> ?";
				}
			}

		$('#deleteModal #delRef').attr('href', href);
		$('#deleteModal').modal();

	});
});	
```
#### common.html
``` html
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<body>
		<div  th:fragment="navbar">
		<div class="container-fluid ">
					<nav class="navbar navbar-expand-lg bg-primary navbar-dark sticky-top" >

					<!--  adding image to the nav bar -->
					<div class="navbar-header m-3">
					    <a class="navbar-brand" href="#">
					      <img class="img-responsive" width="130px" height="" 
src="https://instructure-uploads-apse1.s3.ap-southeast-1.amazonaws.com/account_81960000000000001/attachments/78818/lhub2020-logo.png">
					    </a>
					</div>
					<!--  Finish adding image to the nav bar -->
					
					<!--  adding items to the nav bar -->
						<ul class="navbar-nav">
							<li class="nav-item">
								<a class="nav-link " href="/"><span class="fa fa-home">Home</span></a>
							</li>
					<!--  adding submenus items to the nav bar -->

					<li class="nav-item dropdown">
						<a class="nav-link dropdown-toggle" href="/" data-toggle="dropdown"> Category </a>
						<ul class="dropdown-menu">
							<li><a class="dropdown-item" href="/categories"> View Category </a></li>
							<li><a class="dropdown-item" href="/categories/new"> Add Category </a></li>
						</ul>
					</li>
					<li class="nav-item dropdown">
						<a class="nav-link dropdown-toggle" href="/" data-toggle="dropdown"> Products </a>
						<ul class="dropdown-menu">
							<li><a class="dropdown-item" href="/products"> View Products </a></li>
							<li><a class="dropdown-item" href="/products/new"> Add Product </a></li>
						</ul>
					</li>
					<li class="nav-item dropdown">
						<a class="nav-link dropdown-toggle" href="/" data-toggle="dropdown"> Brands </a>
						<ul class="dropdown-menu">
							<li><a class="dropdown-item" href="/brands"> View Brands </a></li>
							<li><a class="dropdown-item" href="/brands/new"> Add Brand </a></li>
						</ul>
					</li>
						
					<!--  Finish -- adding submenus items to the nav bar -->
									
																
					<!--  Finish adding items to the nav bar -->
					</ul>
						<hr>
						
						<span class="navbar-text m-3">
    									 <a href="/">logout</a>
    					</span>
						
						<form class="form-inline">
							<input type="search" class="form-control" placeholder="search" id="fieldkeyword" />
							<button class="btn btn-primary m-2" id="buttonSearch" ><span class="fa fa-search"></span> </button> 
						</form>	
					</nav>
					<hr>
		</div>
		</div>

		<div  th:fragment="footer">
				<div class="text-center m-3 fixed-bottom"> 
				<h5> Copyright &copy; NTUC Ltd. </h5>
		</div>
			<script src="https://code.jquery.com/jquery-3.3.1.min.js"
			        type="text/javascript"></script>
			<script  src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" type="text/javascript"></script>
			<script  src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" type="text/javascript"></script>
			<script src="../static/main.js" type="text/javascript" th:src="@{/main.js}"></script>
			<script src="../static/nav.js" type="text/javascript" th:src="@{/nav.js}"></script>
		</div>

		<div  th:fragment="header">
				<meta charset="ISO-8859-1">

				    <!-- Required meta tags -->
				    <meta charset="utf-8" > 
				    <meta content="width=device-width, initial-scale=1, shrink-to-fit=no" name="viewport"> 
				    <!-- Bootstrap CSS -->
				    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet"> </link>
				    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"> </link>
		</div>

</body>
</html>
```
#### products.html
``` html
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
<meta charset="ISO-8859-1">
<title>List Products</title>
<div th:replace="common :: header"></div>
</head>
<body>
	<div th:replace="common :: navbar"></div>
	<!-- 2102210 -->
	<div class="container text-center">

		<!-- was Navigation -->
		
		...

							<td><a class="btn btn-primary btn-sm"
								th:href="@{'/products/edit/' + ${product.id}}"><span
									class="fa fa-edit"></span> </a> <a
								class="btn btn-danger btn-sm delBtn "
								th:href="@{'/products/delete/' + ${product.id}}"> <span
									class="fa fa-trash"></span>
							</a></td>
						</tr>

					</th:block>
				</tbody>
			</table>
		</div>
	</div>

	<!-- 210210 For "class="alert alert-danger" id="main"  -->
	<div class="modal fade" id="deleteModal" data-backdrop="static"
		data-keyboard="false" tabindex="-1"
		aria-labelledby="staticBackdropLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="deleteModalLabel">Delete Record</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<div class="alert alert-danger" id="main"></div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-dismiss="modal">Keep</button>
					<a class="btn btn-danger" href="" id="delRef">proceed </a>
				</div>
			</div>
		</div>
	</div>

	<div th:replace="common :: footer"></div>
	<!-- 210210 -->

</body>

</html>
```



---