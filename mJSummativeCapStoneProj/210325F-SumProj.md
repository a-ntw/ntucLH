### Delete Alert

customerProfile.html
```html
...
	<nav class="nav nav-tabs justify-content-end">
		<a class="nav-link" href="/cust">Back</a>
		<a class="nav-link" th:href="@{'/cust/edit/' + ${custId}}">Edit</a>
		
		<!-- <a class="nav-link" th:href="@{'/cust/delete/' + ${custId}}">Delete</a> -->
		<a class="nav-link" data-toggle="modal" data-target="#doubleConfirm" style="color: #17a2b8">Delete</a>
	</nav>
	
	<div class="modal fade" id="doubleConfirm" tabindex="-1" role="dialog" aria-labelledby="doubleConfirm" aria-hidden="true">
	     <div class="modal-dialog" role="document">
	     <div class="modal-content">
	         <div class="modal-header">
	         <h5 class="modal-title" id="doubleConfirm">Are you sure?</h5>
	         <button type="button" class="close" data-dismiss="modal" aria-label="Close">
	             <span aria-hidden="true">&times;</span>
	         </button>
	         </div>
	         <div class="modal-body">
	         Do you want to delete this customer?
	         </div>
	         <div class="modal-footer">
				<a class="nav-link" th:href="@{'/cust/delete/' + ${custId}}">Delete</button></a>
	         	<button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>
	         </div>
	     </div>
	     </div>
	 </div>
...
```
