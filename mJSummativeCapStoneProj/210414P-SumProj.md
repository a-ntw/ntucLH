## html style


### text-align: right
``` html
		<span class="nav-item dropdown form-group col-md-3" style="text-align: right">
			<a class="nav-link active dropdown-toggle" href="/" data-toggle="dropdown">
				YTD</a>
			<ul class="dropdown-menu">
		 		<li><a class="dropdown-item" href="/">YTD</a> </li>
				<li><a class="dropdown-item" href="/chart/6">6M</a></li>
				<li><a class="dropdown-item" href="/">1Y</a></li>
				<li><a class="dropdown-item" href="/chart/24">2Y</a></li>
			</ul>
		</span>	
```
---

### min max
``` html
<input type="text" class="form-control" maxlength="65" size="65" th:field="*{desc2}" required/>

<input type="text" class="form-control" minlength="4" maxlength="20"  th:field="*{invNo}" required/>

<input type="number" min="0" max="300" class="form-control"  th:field="*{rated}" required/>

<div class="form-group col-md-6">
	<label>Daily Rate: </label> 
	<input class="form-control" type="number" min="0" th:field="*{dailyRate}" required/>
	<small class="form-text text-muted">size must be less than or equal to 300</small>
</div>

<div class="form-group col-md-6">
	<label>NRIC: </label>
	<input class="form-control" type="text" pattern=".{9}" th:field="*{nric}" required/>
	<small class="form-text text-muted">Must be unique, size must be 9-chars code</small>
</div>

```
