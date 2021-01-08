#### Starter

* New > 
* Spring Starter project >>> 
* ShoppingCart ? 
    * SpringBootDevTool

### ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
### Product s21 = context.getBean("smartPhone", Product.class);
#### ShoppingCartApp.java
``` java
@SpringBootApplication
public class ShoppingCartApplication {

	public static void main(String[] args) {
//		SpringApplication.run(ShoppingCartApplication.class, args);

//		Product mobileProduct = new Mobile();
//		Product laptopProduct = new Laptop();

		ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);

		Product s21 = context.getBean("smartPhone", Product.class);
		Product g14 = context.getBean("gamingLaptop", Product.class);

		System.out.println(" SmartPhone Details : " + s21);
		System.out.println(" Gaming Laptop Details : " + g14.toString());
	}
}
```

#### Product.java
+ getter, setter, constructor
``` java
public abstract class Product {

	private String name;
	private double price;

	public Product() {
	}

	public Product(String name, double price) {
		super();
		this.name = name;
		this.price = price;
	}

	public String getName() {
  ...
```
### @Bean
#### SpringConfig.java
``` java
// Which will help configure your Spring Container / Framework

@Configuration
public class SpringConfig {

	@Bean // This method is the Constructor for that Bean
	public Product smartPhone() {
		Mobile m = new Mobile("Galaxy_S21", 2000.0);
		m.setMaker("Samsung");
		return m;
	}

	@Bean
	public Product gamingLaptop() {
		Laptop l = new Laptop("Asus_ROG", 3200.0);
		l.setOsType("Win10");
		return l;
	}

}
```
* New > 
* class > 
* Mobile >
    * click - Constructors from superclass
    * click - Inherited abstract methods
    * Superclass: Product (com.cp5.Product)
    * (Auto generated constructor)

#### Mobile.java
+ getter, setter, constructor
``` java
public class Mobile extends Product {

	private String maker;

	public String getMaker() {
		return maker;
	}

	public void setMaker(String maker) {
		this.maker = maker;
	}

	public Mobile() {
		// TODO Auto-generated constructor stub
	}
  ...
```
#### Laptop.java
+ getter, setter, constructor
``` java
public class Laptop extends Product {

	private String osType;

	public String getOsType() {
		return osType;
	}

	public void setOsType(String osType) {
		this.osType = osType;
	}

	public Laptop() {
  ...
```
console
``` console
...
... - Creating shared instance of singleton bean 'springConfig'
... - Creating shared instance of singleton bean 'smartPhone'
... - Creating shared instance of singleton bean 'gamingLaptop'
 SmartPhone Details : Product [name=Galaxy_S21, price=2000.0]Mobile [maker=Samsung]
 Gaming Laptop Details : Product [name=Asus_ROG, price=3200.0]Laptop [osType=Win10]

```

