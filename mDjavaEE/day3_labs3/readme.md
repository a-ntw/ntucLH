Practices for Lesson 3: Managing Persistence bu Using JPA Entities

#### run SQL Developer
* connected to database, HR connection

#### Set up database HR in NetBeans
* connected to database, HR connection in NetBeans
Go to Netbeans > Services > jdbc:oracle...[hr on HR] > Execute Command, OR add in virtual SQL Developer
``` sql
drop table products;
drop sequence pid_seq ;

create table products (
   id           INT PRIMARY KEY,
   name         VARCHAR (40) NOT NULL,
   price        NUMERIC (6,2) NOT NULL,
   best_before  DATE,
   version      INT DEFAULT 1);

CREATE SEQUENCE pid_seq
  MINVALUE 1
  START WITH 1
  INCREMENT BY 1
  CACHE 20;


insert into products values (pid_seq.NEXTVAL, 'Cookie', 2.99, TO_DATE(sysdate, 'dd/mm/yyyy'), 1);
insert into products values (pid_seq.NEXTVAL, 'Cake', 3.99, TO_DATE(sysdate, 'dd/mm/yyyy'), 1);
insert into products values (pid_seq.NEXTVAL, 'Tea', 1.99, TO_DATE(sysdate, 'dd/mm/yyyy'), 1);
insert into products values (pid_seq.NEXTVAL, 'Coffee', 1.99, null, 1);

select * from products;

commit;
```

#### WebLogic
	DataSource > Generic Data Source > Create a New JDBC Data Source
	Name:  product
	JNDI Name: jdbc/productDb
	Database driver: Oracle’s Driver (Thin) for Service Connections. version s: Any

### jdbc.productDB
Day4 Error:
Deployment failed. The message was: javax.naming.NameNotFoundException: While trying to lookup 'jdbc.productDB' didn't find subcontext 'jdbc'. Resolved ''; remaining name 'jdbc/productDB’

	check if productDB is available
	Netbeans > Services 
		> Servers > Oracle WebLogic
		> Resources > JDBC > Connection Pools
	Netbeans > Services
		Oracle WebLogic > right-click View Admin Console
	Login to WebLogic
		> Data Sources > productDB
		> Targets 
		> select AdminServer


### Practice 3-1: Creating a JPA Entity
* Netbeans > File > New Project 
    * > Java > Java Application
* New Java Application dialog:
    * Project Name: ProductClient
    * Project Location: /home/oracle.labs.projects/
    * Project Folder: /home/oracle.labs.projects/ProductClient
    * Select the Create Main Class: demos.client.ProductClient
* Add Libraries
    * ProductClient/Libraries > Add Library ( from wls12214 , or Netbean8.2 folder)
    * Create New Library
        * Library Name: Bean Validation
        * Library Type: Class Libraries
            * jboss-logging-3.1.3.GA.jar
            * validation-api-1.1.0.Final.jar
            * hibernate.validation.jar
            * org.hibernate.hibernate-validator-cdo.jar
            * org.glassfish.javax.el.jar
        * Add Library
            * Java EE 7 API Library
        * Add JAR.Folder
            * ojdbc8.jar (https://www.oracle.com/database/technologies/appdev/jdbc-ucp-183-downloads.html)
            
 #### JPA
 * Create a JOA entity class
    * File > New File > Persistence > Entity Classes from Database
    * select database connection
    * Select the `PRODUCTS`
    * Entity Classes
        * change Class name to: `Product`
        * change Package to: `demos.db`
    * Set Mapping Option
        * Select the `Use Defaults If Possible`
        * Persistence Unit config, persistence.xml, was created in a META-INI.
#### Product.java
/ProductClient/Source Packages/demos.db/Product.java
* Modify the toString
``` sql
    public String toString() {
        return id+" "+name+" "+price+" "+bestBefore+" "+version;
```
* bestBefore to LocalDate, add code before the ID, version, *NotNull, size
``` sql
import javax.persistence.GeneratedValue; // auto-genedate
import javax.persistence.SequenceGenerator; // auto-genedate
import static javax.persistence.GenerationType.SEQUENCE; // auto-genedate
import javax.persistence.Version;
import javax.validation.constraints.NotNull; ...Size;...Max; ...Min
    ...
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @SequenceGenerator(name="pidGen", sequenceName="PID_SEQ", allocationSize=1)
    @GeneratedValue(strategy=SEQUENCE,generator="pidGen")
    @NotNull
    private Integer id;
    @NotNull
    @Size(min=3, max=40, message="(prod.name")
    private String name;
    @Max(value=1000, message="{prod.price.max}")  
    @Min(value=1, message="{prod.price.min}")
    
    private BigDecimal price;
    @Column(name = "BEST_BEFORE")
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDate bestBefore; // WAS//private Date bestBefore;
    @Version
    private Integer version;
    ...
    public LocalDate getBestBefore() {
        return bestBefore;
    }

    public void setBestBefore(LocalDate bestBefore) {
        this.bestBefore = bestBefore;
    }
```
#### validationMessages.properties
* Files > New File > Others > Properties File
* New Properties File
    * File Name: ValidationMessages
    * Folder: src
    * Add the messages:
```
    prod.name=Name cannot be shorter than (min) or longer than (max)
    prod.price.max=Price must be smaller than (value)
    prod.price.min=Price must be greater than (value)%      
```
#### DateConverter.java
* File > New File > Java > Java Class
* New Java Class
    * Class Name: DateConverter
    * Package: demos.db
``` java
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
...
@Converter(autoApply=true)
public class DateConverter implements AttributeConverter<LocalDate, Date> {

    @Override
    public Date convertToDatabaseColumn(LocalDate value) {
        return (value==null) ? null :
        Date.from(value.atStartOfDay(ZoneId.systemDefault()).toInstant());
    }

    @Override
    public LocalDate convertToEntityAttribute(Date value) {
        return (value==null) ? null : Instant.ofEpochMilli(value.getTime())
                .atZone(ZoneId.systemDefault()).toLocalDate();
    }
}
```
#### persistence.xml
* Source Packages > META-INF > persistence.xml > Source
* Add to register the DateConveter class, `<class>demos.db.DateConverter</class>`
``` xml
    ...
    <provider>org.eclipse.persistence.jpa.PersistenceProvider</provider>
    <class>demos.db.DateConverter</class>
    <class>demos.db.Product</class>
    <properties>
    ...
```
#### Modify the Named Query Product.findByName. Add Product.findTotal 
``` sql
    , @NamedQuery(name = "Product.findByName", query = "SELECT p FROM Product p WHERE p.name like :name")
    , @NamedQuery(name = "Product.findTotal", query = "SELECT count(p.id), sum(p.price) FROM Product p WHERE p.id in :ids")
```
#### Clean and Build Project, SHIFT+F11

### Practice 3-2: Creating a JPA Controller
#### ProductManager.java
* File > New File > Java > Java Class
* New Java Class
    * Class Name: ProductManager
    * Package: demos.model
``` java
...
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class ProductManager {
   
    private EntityManager em;
    private Query productNameQuery;
    
    public ProductManager(String persistenceUnit) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(persistenceUnit);
        em = emf.createEntityManager();
        productNameQuery = em.createNamedQuery("Product.findByName");
    }
    public void closeEntityManager(){
        em.close();
    }
    public void create(@Valid Product product) {
        em.getTransaction().begin();
        em.persist(product);
        em.getTransaction().commit();
    }
    public void update(@Valid Product product) {
        em.getTransaction().begin();
        product = em.merge(product);
        em.getTransaction().commit();
    }
    public void delete(Product product) {
        em.getTransaction().begin();
        em.remove(product);
        em.getTransaction().commit();
    }
     public Product findProduct(Integer id) {
        return em.find(Product.class, id);
    }
    public List<Product> findProductByName(String name) {
        productNameQuery.setParameter("name", name);
        return productNameQuery.getResultList();
    }
}
```
#### Clean and Build Project, SHIFT+F11

#### errors during practices
* Add ojdbc8.jar into Libraries
* Product.java edit
	* change Products to Product for Product.java
	* change BigDecimal ID to Integer ID

### Practice 3-3: testing JPA Functionalities
#### ProductClient.java
``` java
...
public class ProductClient {

    private static final Logger logger = Logger.getLogger(ProductClient.class.getName());

    public static void main(String[] args) {
        try {
            ProductManager pm = new ProductManager("ProductClientPU");

//            Product p = pm.findProduct(1);
//            System.out.println(p);

            List<Product> products = pm.findProductByName("Co%");
            products.stream().forEach(p -> System.out.println(p));
            
            pm.closeEntityManager();
        } catch (Exception ex) {
            Throwable cause = ex.getCause();
            if (cause instanceof ConstraintViolationException) {
                ConstraintViolationException e = (ConstraintViolationException) cause;
                e.getConstraintViolations().stream().forEach(v -> logger.log(Level.INFO, v.getMessage()));
            } else if (cause instanceof OptimisticLockException) {
                OptimisticLockException e = (OptimisticLockException) cause;
                logger.log(Level.INFO, e.getMessage());
            } else {
                logger.log(Level.SEVERE, "Product Manager Error", ex);
            }
        }
    }
}

```
#### Open SQL console to view data
* Services > Databases > jdbc connection > HR > Tables > PRODUCTS
* right-click PRODUCTS > View Data

#### Replace with code that finds, changes, validates and update the first product
``` java
//            Product p = pm.findProduct(1);
//            p.setPrice(BigDecimal.valueOf(2.5));
//            p.setBestBefore(LocalDate.now().plusDays(1));
//            pm.update(p);
```
#### Add code to pause the program
``` java
//            Product p = pm.findProduct(1);
//            p.setPrice(BigDecimal.valueOf(5));
//            Scanner s = new Scanner(System.in);
//            System.out.println("Click here and  then press enter to continue");
//            s.nextLine();
//            pm.update(p);
```
