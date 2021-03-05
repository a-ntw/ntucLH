### LoggingBeanPostProcessor
#### LoggingBeanPostProcessor.java
``` java
/**
 * A simple bean post-processor that logs each newly created bean it sees. Inner
 * beans are ignored.  A very easy way to see what beans you have created and
 * less verbose than turning on Spring's internal logging.
 */
public class LoggingBeanPostProcessor implements BeanPostProcessor {

	private final Logger logger = LoggerFactory.getLogger(getClass());

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName)
			throws BeansException {
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName)
			throws BeansException {

		// Log the names and types of all non inner-beans created
		if (!beanName.contains("inner bean"))
			logger.info("NEW " + bean.getClass().getSimpleName() + " -> "
					+ beanName);

		return bean;
	}

}
```
#### TestInfrastructureConfig.java
``` java
@Configuration
//@Import({
//	TestInfrastructureLocalConfig.class,
//	TestInfrastructureJndiConfig.class,
//	RewardsConfig.class })
public class TestInfrastructureConfig {

	/**
	 * The bean logging post-processor from the bean lifecycle slides.
	 */
	@Bean
	public static LoggingBeanPostProcessor loggingBean(){
		return new LoggingBeanPostProcessor();
	}
}

```
#### DevCarDateTests.java
``` java
@SpringJUnitConfig(classes=TestInfrastructureConfig.class)
//@ActiveProfiles({ "local", "jdbc" })
public class DevCarDateTests {

	/**
	 * The object being tested.
	 */
//	@Autowired // will test fail if Autowired. ?
	private Employee employee;
	
	private Integer TestValue = 11;

//	@Disabled
	@Test
	@DisplayName("test if works")
	public void testToday() {

		assertEquals(TestValue, 11);
	}
}
```
#### myMockTest.java
``` java
@SpringBootTest (webEnvironment = WebEnvironment.MOCK)
@AutoConfigureMockMvc
public class myMockTest {
	
	@Autowired
	MockMvc mockMvc;
	
	/* Only work on /login, other not work, guess due to security, or need login password*/
//	@Disabled
	@Test
	public void testBasicGet() throws Exception {
		mockMvc.perform(
			get("/login"))
			.andDo(print())
			.andExpect(status().isOk());
	}

}
```
