
LoggerAspect
===
[top]: topOfThePage


LoggerAspect.java
``` java
@Aspect
@Component
public class LoggerAspect {
	
	Logger log = LoggerFactory.getLogger(LoggerAspect.class);
	
	@Autowired
	private CustomerDao customerDao;
	
	@Before("execution(public String deleteCustomer(..))")
	public void doLog(JoinPoint jp) {
		Object obj = jp.getArgs()[0];
		Long l = Long.parseLong(obj.toString());
		System.out.println(l);
		
		Customer customer = customerDao.getCustomerById(l);
		System.out.println("  ===> customer " + customer.toString());
		System.out.println("Request to delete by the name, " + customer.getCustName() 
		+ ", with an Customer ID = " + l + " has been Received.");
//		log.info(customer.toString());
		System.out.println(" ==> getSignature :: " + jp.getSignature());
		System.out.println(" ==> getStaticPart :: " + jp.getStaticPart());
	}

```



``` console
...
81
  ===> customer com.cp5.Customer@1a1c471e
Request to delete by the name, Erisson John, with an Customer ID = 81 has been Received.
 ==> getSignature :: String com.cp5.CustomerController.deleteCustomer(long)
 ==> getStaticPart :: execution(String com.cp5.CustomerController.deleteCustomer(long))

```


210120JBankAppSc.png <img src="210120JBankAppSc.png">

---
[:top: Top](#top)
