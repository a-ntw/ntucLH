ManyToMany NavBar BootStrap
===

#### Directory arrangement
antw@Mac-mini ntuc % ls -R -1
* [AppController.java](/mHCapStoneProj6/210208B-SpringManyToMany/SpringBootOneToMany/src/main/java/com/ntuc/AppController.java)
* SpringBootManyToManyApplication.java

./controller:
- [BrandController.java](/mHCapStoneProj6/210208B-SpringManyToMany/SpringBootOneToMany/src/main/java/com/ntuc/controller/BrandController.java)
- [CategoryController.java](/mHCapStoneProj6/210208B-SpringManyToMany/SpringBootOneToMany/src/main/java/com/ntuc/controller/CategoryController.java)
- [ProductController.java](/mHCapStoneProj6/210208B-SpringManyToMany/SpringBootOneToMany/src/main/java/com/ntuc/controller/ProductController.java)

./model:
- [Brands.java](/mHCapStoneProj6/210208B-SpringManyToMany/SpringBootOneToMany/src/main/java/com/ntuc/model/Brands.java)
- [Category.java](/mHCapStoneProj6/210208B-SpringManyToMany/SpringBootOneToMany/src/main/java/com/ntuc/model/Category.java)
- [ProductDetails.java](/mHCapStoneProj6/210208B-SpringManyToMany/SpringBootOneToMany/src/main/java/com/ntuc/model/ProductDetails.java)
- [Products.java](/mHCapStoneProj6/210208B-SpringManyToMany/SpringBootOneToMany/src/main/java/com/ntuc/model/Products.java)

./repository:
- [BrandRepository.java](/mHCapStoneProj6/210208B-SpringManyToMany/SpringBootOneToMany/src/main/java/com/ntuc/repository/BrandRepository.java)
- [CategoryRepository.java](/mHCapStoneProj6/210208B-SpringManyToMany/SpringBootOneToMany/src/main/java/com/ntuc/repository/CategoryRepository.java)
- [ProductRepository.java](/mHCapStoneProj6/210208B-SpringManyToMany/SpringBootOneToMany/src/main/java/com/ntuc/repository/ProductRepository.java)

antw@Mac-mini resources % ls -R -1    
* application.properties

./static:
- bootstrap.min.css
- bootstrap.min.js
- jquery-3.5.1.min.js
- [main.js](/mHCapStoneProj6/210208B-SpringManyToMany/SpringBootOneToMany/src/main/resources/static/main.js)

./templates:
- [brand_form.html](/mHCapStoneProj6/210208B-SpringManyToMany/SpringBootOneToMany/src/main/resources/templates/brand_form.html)
- [brands.html](/mHCapStoneProj6/210208B-SpringManyToMany/SpringBootOneToMany/src/main/resources/templates/brands.html)
- [bsNavBar.html](/mHCapStoneProj6/210208B-SpringManyToMany/SpringBootOneToMany/src/main/resources/templates/bsNavBar.html)
- [categories.html](/mHCapStoneProj6/210208B-SpringManyToMany/SpringBootOneToMany/src/main/resources/templates/categories.html)
- [category_form.html](/mHCapStoneProj6/210208B-SpringManyToMany/SpringBootOneToMany/src/main/resources/templates/category_form.html)
- [index.html](/mHCapStoneProj6/210208B-SpringManyToMany/SpringBootOneToMany/src/main/resources/templates/index.html)
- [product_form.html](/mHCapStoneProj6/210208B-SpringManyToMany/SpringBootOneToMany/src/main/resources/templates/product_form.html)
- [products.html](/mHCapStoneProj6/210208B-SpringManyToMany/SpringBootOneToMany/src/main/resources/templates/products.html)
- [welcome.html](/mHCapStoneProj6/210208B-SpringManyToMany/SpringBootOneToMany/src/main/resources/templates/welcome.html)

antw@Mac-mini resources % 

210208ManyToMany.png <img src="210208ManyToMany.png">

#### Category.java
``` java
@Entity
public class Category {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(length = 45, nullable = false, unique=true)
	private String name;
	
//	@ManyToOne
//	@JoinColumn(name= "brand_id")
//	private Brands brand;
	

	@ManyToMany
	@JoinTable(
			name = "brands_categories",
			joinColumns = @JoinColumn(name = "category_id"),
			inverseJoinColumns = @JoinColumn(name = "brand_id")
			)
	
	private List<Brands> brand = new ArrayList<>();
	...

	public List<Brands> getBrand() {
		return this.brand;
	}
	public void setBrand(List<Brands> brand) {
		this.brand = brand;
	}
	
	// For display output thru html page
	@Override
	public String toString() {
		return  name ;
	}
```

#### Brands.java
``` java
@Entity
public class Brands {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(length = 45, nullable = false, unique=true)
	private String name;
	
//	@OneToMany
//	@JoinColumn(name = "brand_id")
//	private List<Category> categories = new ArrayList<>();

	@ManyToMany
	@JoinTable(
			name = "brands_categories",
			joinColumns = @JoinColumn(name = "brand_id"),
			inverseJoinColumns = @JoinColumn(name = "category_id")
			)	

	private List<Category> categories = new ArrayList<>();
	...
	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}	
```

#### Products.java
``` java
@Entity
public class Products {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(length = 150, nullable = false, unique=true)
	private String name;
	private float price;
	
	@ManyToOne
	@JoinColumn(name= "category_id")
	private Category category;
	
	@OneToMany(mappedBy ="product", cascade = CascadeType.ALL)
	private List<ProductDetails> details = new ArrayList<>();
	...
	public void setDetails(Integer id,String name, String value) {
		this.details.add(new ProductDetails(id,name,value,this)  );
		
	}

	public void addDetail(String name, String value) {
		this.details.add(new ProductDetails(name,value,this));
	}	
```

#### ProductDetails.java 
``` java
@Entity
@Table(name="product_details")
public class ProductDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(length = 45, nullable = false)
	private String name;
	
	@Column(length = 45, nullable = false)
	private String value;
	
	@ManyToOne
	@JoinColumn(name="product_id")
	private Products product;
	
	public ProductDetails() {}

	public ProductDetails(Integer id, String name, String value, Products product) {
		this.id = id;
		this.name = name;
		this.value = value;
		this.product = product;
	}

	public ProductDetails( String name, String value, Products product) {
		this.name = name;
		this.value = value;
		this.product = product;
	}
```
#### ProductController.java
```java

	@GetMapping("/products")
	public String listProducts(Model model) {
		List<Products> listProducts = repo.findAll();
		model.addAttribute("listProducts",listProducts);
		return "products";
	}
	
	@GetMapping("/products/new")
	public String showNewProductForm(Model model) {
		List<Category> listCategories =  catrepo.findAll();
		model.addAttribute("product", new Products());
		model.addAttribute("listCategories",listCategories);
		return "product_form";
		
	}
	
	
	@PostMapping("/products/save")
	public String saveProduct(Products product, HttpServletRequest request) {
		String[] detailIDs = request.getParameterValues("detailID");
		String[] detailNames = request.getParameterValues("detailName");
		String[] detailValues = request.getParameterValues("detailValue");
		
		for (int i = 0; i< detailNames.length; i++) {
			if(detailIDs != null && detailIDs.length > 0)
				product.setDetails(Integer.valueOf(detailIDs[i]), detailNames[i], detailValues[i]);
			else {
				product.addDetail(detailNames[i], detailValues[i]);
		}
		}
		repo.save(product);
		return "redirect:/products";
	}

	
	@GetMapping("/products/edit/{id}")
	public String ShowProductEditForm(@PathVariable("id") Integer id, Model model) {
		Products product = repo.findById(id).get();
		model.addAttribute("product", product);
		List<Category> listCategories = catrepo.findAll();
		model.addAttribute("listCategories", listCategories);
		return "product_form";
		
	}
	
	@GetMapping("/products/delete/{id}")
	public String ShowProductDeleteForm(@PathVariable("id") Integer id, Model model) {
		repo.deleteById(id);
		return "redirect:/products";
	}
	
```

#### product.html
``` java
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
<meta charset="ISO-8859-1">
<title>List Products</title>

<link rel="stylesheet" th:href="@{/bootstrap.min.css}">
<script th:src="@{/jquery-3.5.1.min.js}"></script>
<script th:src="@{/bootstrap.min.js}"></script>

</head>
<body>

<div class="container text-center">

<!-- Navigation -->
<nav class="navbar navbar-expand-lg navbar-dark bg-dark static-top">
<div class="container">
	<a class="navbar-brand" href="/">:: Inventory Management ::</a>
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarResponsive" aria-controls="navbarResponsive"
		aria-expanded="false" aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>

	<div class="collapse navbar-collapse" id="navbarResponsive">
	<ul class="navbar-nav ml-auto">
		<li class="nav-item active"><a class="nav-link" href="/">Home
			<span class="sr-only">(current)</span>
		</a></li>
		<li class="nav-item"><a class="nav-link"
			th:href="@{/categories}">Category</a></li>
		<li class="nav-item"><a class="nav-link"
			th:href="@{/products}">Products</a></li>
		<li class="nav-item"><a class="nav-link" th:href="@{/brands}">Brands</a></li>
		<!-- 	 <form class="form-inline">
			<input type="search" class="form-control" placeholder="search"
				id="fieldkeyword" />
			<button class="btn btn-primary m-2" id="buttonSearch">
				Search</button>
		</form> -->
	</ul>
	</div>
</div>
</nav>

<div>
<div>
	<h1>Product List</h1>
</div>
<div class="p-2">
	<a class="h4" th:href="@{/products/new}">Create New Product</a>
</div>
<div>
<table class="table table-bordered">
	<thead class="thead-dark">
		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>Price</th>
			<th>Category</th>
			<th>Details</th>
			<th>Actions</th>
		</tr>
	</thead>
	<tbody>
		<th:block th:each="product : ${listProducts}">
		<tr>
			<td>[[${product.id}]]</td>
			<td>[[${product.name}]]</td>
			<td>[[${product.price}]]</td>
			<td>[[${product.category.name}]]</td>
			<td>[[${product.details}]]</td>
			<td><a th:href="@{'/products/edit/' + ${product.id}}">
					Edit </a> <a th:href="@{'/products/delete/' + ${product.id}}">
					Delete </a></td>

		</tr>
		</th:block>
	</tbody>
</table>
</div>

</div>

<div class="text-center m-3">
	<h5>Copyright &copy; NTUC Ltd.</h5>
</div>
</div>

<Script>
</Script>
</body>

</html>
```

#### product_form.html
``` html
<body>

<div class="container text-center"> 
<!-- Navigation -->
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark static-top">
	<div class="container">

	<a class="navbar-brand" href="/">:: Inventory Management ::</a>
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarResponsive" aria-controls="navbarResponsive"
		aria-expanded="false" aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>

	<div class="collapse navbar-collapse" id="navbarResponsive">
	<ul class="navbar-nav ml-auto">
		<li class="nav-item active"><a class="nav-link" href="/">Home
				<span class="sr-only">(current)</span>
		</a></li>
		<li class="nav-item"><a class="nav-link"
			th:href="@{/categories}">Category</a></li>
		<li class="nav-item"><a class="nav-link"
			th:href="@{/products}">Products</a></li>
		<li class="nav-item"><a class="nav-link" th:href="@{/brands}">Brands</a></li>
		<!-- 						<form class="form-inline">
			<input type="search" class="form-control" placeholder="search"
				id="fieldkeyword" />
			<button class="btn btn-primary m-2" id="buttonSearch">
				Search</button>
		</form> -->
	</ul>
	</div>
	</div>
	</nav>
		
	<div> 	<h1>Create New Product</h1> </div>

	<form th:action="@{/products/save}" th:object="${product}" method="post" style="max-width: 600px; margin: 0 auto;">
		<input type="hidden"  th:field="*{id}" th:value="${product.id}" />   
	<div class="m-3">
	<div class="form-group row">
		<label class="col-form-label col-sm-18"> Product Name : </label>
		<div class="col-sm-8">
			<input type="text" th:field="*{name}" step= "0.1" class="form-control" required />
		</div>
	</div>	

	<div class="form-group row">
		<label class="col-form-label col-sm-18"> Product Price : </label>
		<div class="col-sm-8">
			<input type="number" th:field="*{price}" class="form-control" required />
		</div>
	</div>	
	</div>

	<div class="form-group row">
		<label class="col-form-label col-sm-18"> Product Category : </label>
		<div class="col-sm-8">
			<select th:field="*{category}" class="form-control" required>
				<th:block th:each="cat : ${listCategories}">
					<option th:text="${cat.name}" th:value="${cat.id}" />
				</th:block>
			</select>

		</div>
	</div>	

	<th:block th:unless="${product.id == null}"  th:each ="detail, status : ${product.details}">
	<input type="hidden" name="detailID" th:value="${detail.id}" />
	<div class="form-group row">
		<label class="col-form-label col-sm-18"> Details #[[status.count]] : </label>
		<div class="col-sm-4">
			<input type="text" name="detailName"  th:value="${detail.name}"   class="form-control" required />
		</div>
		<div class="col-sm-4">
			<input type="text" name="detailValue" th:value="${detail.value}"  class="form-control" required />
		</div>
	</div>			
	</th:block>

	<th:block th:if="${product.id == null}">
	<div class="form-group row">
		<label class="col-form-label col-sm-18"> Details #1 : </label>
		<div class="col-sm-4">
			<input type="text" name="detailName"  placeholder="Name"  step= "0.1" class="form-control" required />
		</div>
		<div class="col-sm-4">
			<input type="text" name="detailValue" placeholder="Value" step= "0.1" class="form-control" required />
		</div>
	</div>			

	<div class="form-group row">
		<label class="col-form-label col-sm-18"> Details #2 : </label>
		<div class="col-sm-4">
			<input type="text" name="detailName"  placeholder="Name"  step= "0.1" class="form-control" required />
		</div>
		<div class="col-sm-4">
			<input type="text" name="detailValue" placeholder="Value" step= "0.1" class="form-control" required />
		</div>
	</div>			

	<div class="form-group row">
		<label class="col-form-label col-sm-18"> Details #3 : </label>
		<div class="col-sm-4">
			<input type="text" name="detailName"  placeholder="Name"  step= "0.1" class="form-control" required />
		</div>
		<div class="col-sm-4">
			<input type="text" name="detailValue" placeholder="Value" step= "0.1" class="form-control" required />
		</div>
	</div>			

	</th:block>
		<div class="text-center p-3">
			<button type="submit" class="btn btn-primary" > Save </button>
		</div>
	</form>
</div>

</body>
```
#### pom.xml
``` xml
	<dependencies>
		<dependency>
			<groupId> org.webjars </groupId>
			<artifactId> bootstrap </artifactId>
			<version> 4.3.1</version> 
		</dependency>
		
		<dependency>
			<groupId> org.webjars </groupId>
			<artifactId> webjars-locator-core</artifactId>
		</dependency>
		
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-data-jpa</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-thymeleaf</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-web</artifactId>
		</dependency>

		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-devtools</artifactId>
			<scope>runtime</scope>
			<optional>true</optional>
		</dependency>
		<dependency>
			<groupId>com.oracle.database.jdbc</groupId>
			<artifactId>ojdbc8</artifactId>
			<scope>runtime</scope>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-test</artifactId>
			<scope>test</scope>
		</dependency>
	</dependencies>
```

#### brands.html
``` html
	<table class="table table-bordered">
		<thead class="thead-dark">
		<tr>
			<th> ID </th>
			<th> Name </th>
			<th> Category </th>
			<th> Modify </th>
		</tr>
		</thead>
		<tbody>
			<th:block th:each="brand : ${listBrands}">
				<tr> 
				<td> [[${brand.id}]]</td>
				<td> [[${brand.name}]]</td>
				<td> [[${brand.categories}]]</td>
				<td>
					<a th:href="@{'/brands/edit/' + ${brand.id}}"> Edit </a>
					<a th:href="@{'/brands/delete/' + ${brand.id}}"> Delete </a>
				</td>
				</tr>
			</th:block>
		</tbody>
	</table>
```

---
### Create New Brand
ref: SpringBootManyToMany
####BrandController.java
``` java
	@GetMapping("/brands/new")
	public String ShowNewBrandForm(Model model) {
		model.addAttribute("brand", new Brands());
		List<Category> listcategories = catrepo.findAll();
		model.addAttribute("listcategories",listcategories);
		return "brand_form";
	}
	
	@PostMapping("/brands/save")
	public String saveBrand(Brands brand) {
		repo.save(brand);
		return "redirect:/brands";
	}
```
#### brand_form.html
drop down categories
``` html
<form th:action="@{/brands/save}" th:object="${brand}" method="post" style="max-width: 600px; margin: 0 auto;">
	<input type="hidden"  th:field="*{id}" th:value="${brand.id}" />   
	<div class="m-3">
		<div class="form-group row">
			<label class="col-form-label col-sm-18"> Brand Name : </label>
			<div class="col-sm-8">
				<input type="text" th:field="*{name}" step= "0.1" class="form-control" required />
			</div>
		</div>	
	</div>

	<div class="form-group row">
		<label class="col-form-label col-sm-18"> Choose One or more Categories : </label>
		<div class="col-sm-8">
			<select th:field="*{categories}" class="form-control" required multiple="multiple"> 
				<th:block th:each="cat : ${listcategories}">
					<option th:text="${cat.name}" th:value="${cat.id}" />
				</th:block>
			</select>
		</div>
	</div>	

	<div class="text-center p-3">
		<button type="submit" class="btn btn-primary" > Save </button>
	</div>
</form>
```
#### BrandController.java
``` java
@Controller
public class BrandController {

	@Autowired
	private BrandRepository repo;
	
	@Autowired
	private CategoryRepository catrepo;
	
	@GetMapping("/brands/new")
	public String ShowNewBrandForm(Model model) {
		model.addAttribute("brand", new Brands());
		List<Category> listcategories = catrepo.findAll();
		model.addAttribute("listcategories",listcategories);
		return "brand_form";
	}
	
	@PostMapping("/brands/save")
	public String saveBrand(Brands brand) {
		repo.save(brand);
		return "redirect:/brands";
	}
	
	@GetMapping("/brands")
	public String  listBrands(Model model) {
		List<Brands> listBrands = repo.findAll();
		model.addAttribute("listBrands",listBrands);
		return "brands";
	}
	
	@GetMapping("/brands/edit/{id}")
	public String ShowBrandEditForm(@PathVariable("id") Integer id, Model model) {
		Brands brand = repo.findById(id).get();
		model.addAttribute("brand",brand);
		List<Category> listcategories = catrepo.findAll();
		model.addAttribute("listcategories", listcategories);
		return "brand_form";
	}
}
```

---
## requests.getParameterValues
#### Products.java
``` java
	@OneToMany(mappedBy ="product", cascade = CascadeType.ALL)
	private List<ProductDetails> details = new ArrayList<>();
	
	public void setDetails(Integer id,String name, String value) {
		this.details.add(new ProductDetails(id,name,value,this)  );
	}

	public void addDetail(String name, String value) {
		this.details.add(new ProductDetails(name,value,this));
	}
```
#### ProductController.java
``` java
	@PostMapping("/products/save")
	public String saveProduct(Products product, HttpServletRequest request) {
		String[] detailIDs = request.getParameterValues("detailID");
		String[] detailNames = request.getParameterValues("detailName");
		String[] detailValues = request.getParameterValues("detailValue");
		
		for (int i = 0; i< detailNames.length; i++) {
			if(detailIDs != null && detailIDs.length > 0)
				product.setDetails(Integer.valueOf(detailIDs[i]), detailNames[i], detailValues[i]);
			else {
				product.addDetail(detailNames[i], detailValues[i]);
		}}
		repo.save(product);
		return "redirect:/products";
	}
	
	@GetMapping("/products/edit/{id}")
	public String ShowProductEditForm(@PathVariable("id") Integer id, Model model) {
		Products product = repo.findById(id).get();
		model.addAttribute("product", product);
		List<Category> listCategories = catrepo.findAll();
		model.addAttribute("listCategories", listCategories);
		return "product_form";
	}	
```
#### product_form.html
``` html
<form th:action="@{/products/save}" th:object="${product}" method="post" style="max-width: 600px; margin: 0 auto;">
	<input type="hidden"  th:field="*{id}" th:value="${product.id}" />   
	
	...
	
	<th:block th:unless="${product.id == null}"  th:each ="detail, status : ${product.details}">
		<input type="hidden" name="detailID" th:value="${detail.id}" />
		<div class="form-group row">
			<label class="col-form-label col-sm-18"> Details #[[status.count]] : </label>
			<div class="col-sm-4">
				<input type="text" name="detailName"  th:value="${detail.name}"   class="form-control" required />
			</div>
			<div class="col-sm-4">
				<input type="text" name="detailValue" th:value="${detail.value}"  class="form-control" required />
			</div>
		</div>			
	</th:block>
```

---
