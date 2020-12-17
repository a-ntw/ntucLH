Pracitics for Lessoon 4:
## Implementing Business Logic by Using EJBs

---
### Creating an EJB Module
#### EJB Module
* Select File > Open Project
* Select the `ProductApp` and `ProductApp-client` projects
* Select the **Open Required Projects** check box.

#### EJB handling JPA
* Select the **ProductApp-ejb** 
* Select File > New File
* Select **Enterprise JavaBeans** and **Session Bean**
* New Session Bean
  * EJB Name: ProductFacade
  * Package: demos.model
  * Stateless

#### Remote Interface
* Select the **ProductApp-ejb**
* Select File > New File
* Select **Java** and **Java Interface**
* New Java Interface
  * Class name: ProductFacadeRemote
  * Package: demos.model
  
#### Businees method definitions to Remote
* [ProductFacadeRemote.java](https://github.com/alvintwng/ntucLH/blob/master/mDjavaEE/day4_labs4/projects/ProductApp/ProductApp-ejb/src/java/demos/model/ProductFacadeRemote.java)
``` java
@Remote
public interface ProductFacadeRemote {
    void create(@Valid Product product);
    void update(@Valid Product product);
    void delete(Product product);
    Product findProduct(Integer id);
    List<Product> findProductByName(String name);
}
```

#### Business method implementations to ProductFacade EJB
* ProductFacade.java
  * implement all abstract methods
  * injects Persistence Context:
``` java
public class ProductFacade implements ProductFacadeRemote {

    @PersistenceContext(unitName = "ProductApp-ejbPU")
    private EntityManager em;
    ...
```
* replace code as in [ProductFacade.java](https://github.com/alvintwng/ntucLH/blob/master/mDjavaEE/day4_labs4/projects/ProductApp/ProductApp-ejb/src/java/demos/model/ProductFacade.java)
  * create method
    * validation annotation `(@Valid ...
  * update method
    * validation annotation `(@Valid ...`
  * delete method
  * findProduct method
  * findProductByName method
  * findProductByDate
  * findByBestBeforeDate
  * findTotal
  * validate product object
``` java
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public void validateProduct(@Valid Product product) {
    }
```
* Compile the **ProductApp-ejb** project using **Clean and Build**
#### Deploy ProductApp
* Right-click the **ProductApp** project and select **Deploy**
* should. get a BUILD SUCCESSFUL.

---
### Creating an EJB Client
#### set up a Logger
* Select the **ProductApp-client**
* Expand **Source Packages** > **demos.model**
* Logger to ProductManager.java
``` java
    private static final Logger logger = Logger.getLogger(ProductManager.class.getName());
```
* Add an instance variable that reference to ProductFacadeRemote object
``` java
    // Declare remote EJB reference
    private ProductFacadeRemote productFacade;
```
#### Modify the constructor for remote EJB lookup
``` java
    public ProductManager() {
        // Initialise remote EJB reference by making a JDNI lookup
        try {
            Context ctx = new InitialContext();
            productFacade = (ProductFacadeRemote)ctx.lookup("java:global/ProductApp/ProductApp-ejb/ProductFacade!demos.model.ProductFacadeRemote");
        } catch (Exception ex) {
            logger.log(Level.SEVERE, "Error initialising EJB reference", ex);
        }
    }
```
#### Business operations
* Add code
  * `productFacade.create(product);`
  * `productFacade.update(product);`
  * `productFacade.delete(product);`
  * `return productFacade.findProduct(id);`
  * `return productFacade.findProductByName(name);`
* as in [ProductManager.java](https://github.com/alvintwng/ntucLH/blob/master/mDjavaEE/day4_labs4/projects/ProductApp-client/src/demos/model/ProductManager.java)

#### define connection properties, jndi.properties
* Select **ProductApp-client**
* Select File > New File
* Select **Other** and **Properties**
* New Properties File
  * File Name: jndi
  * Folder: src
``` properties
java.naming.factory.initial=weblogic.jndi.WLInitialContextFactory
java.naming.provider.url=t3://localhost:7001
java.naming.security.principal=weblogic
java.naming.security.credentials=welcome1
```
* Compile the ProductApp-client project usign Clean and Build

### Testing the EJB Client
#### find and print the product with ID 1:
* modify the `ProductClient` class
``` java
//            Product p = pm.findProduct(1);
//            System.out.println(p);

//            List<Product> products = pm.findProductByName("Co%");
//            products.stream().forEach(p -> System.out.println(p));

//            Product p = pm.findProduct(1);
//            p.setPrice(BigDecimal.valueOf(2.5));
//            p.setBestBefore(LocalDate.now().plusDays(1));
//            pm.update(p);

//            Product p = pm.findProduct(1);
//            p.setPrice(BigDecimal.valueOf(5));
//            Scanner s = new Scanner(System.in);
//            System.out.println("Click here and  then press enter to continue");
//            s.nextLine();
//            pm.update(p);

//            Product p = new Product();
//            p.setName("Milk");
//            p.setPrice(BigDecimal.valueOf(2));
//            pm.create(p);

//            Product p = pm.findProduct(5);
//            pm.delete(p);
```
* as in [ProductClient.java](https://github.com/alvintwng/ntucLH/blob/master/mDjavaEE/day4_labs4/projects/ProductApp-client/src/demos/client/ProductClient.java)

---
### Creating an EJB Timer
#### Singleton Timer Session EJB
* Select the **ProductApp-ejb**
* Select File > New File
* Select **Enterprise JavaBeans** and **Timer Session Bean**
* New Tzimer Session Bean dialog box
  * EJB Name: ExpiringProduct
  * Package: demos.model
  * Session Type: Select the **Singleton** option
  * Deselect the **Expose timer method into interfaces**
#### to handle products that are due to expire
* class declaration and initializarion of a Logger object
``` java
    private static final Logger logger = Logger.getLogger(ExpiringProduct.class.getName());
```
* inject a ProductFacade EJB reference
``` java
    @EJB
    private ProductFacade productFacade;
```
* rename `myTimer` method to `handleExpiringProducts`
* replace code with
``` java
List<Product> products = productFacade.findProductByDate(LocalDate.now().plusDays(1));
```
* writing information to the log
``` java
        products.stream().forEach(p -> logger.log(Level.INFO, p.toString()));
```
* as in [ExpiringProduct.java](https://github.com/alvintwng/ntucLH/blob/master/mDjavaEE/day4_labs4/projects/ProductApp/ProductApp-ejb/src/java/demos/model/ExpiringProduct.java)
#### Test the timer
* take note current time
* Modify schedule hour amd minutes
* Right-click the **ProductApp** and **Deploy**
* Click the **Oracle WebLogic Server** tab in the **Output**

---
