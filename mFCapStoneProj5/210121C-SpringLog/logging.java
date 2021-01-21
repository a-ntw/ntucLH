package ntuc;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class logging {
	@After ("execution(public String DoSomething())")
	public void AfterLogging() {
		System.out.println(" ====>  After Logged");
	}

	@Around ("execution(public String DoSomething())")
	public Object DoLogging(ProceedingJoinPoint joinPoint) throws Throwable{

		try {
			System.out.println("Checking Something");  			// @Before
			Object res = joinPoint.proceed();
			System.out.println("Something has been Executed");  //@After
			return res;
			} catch (Throwable e) {
			e.printStackTrace();
		}
	return null;
	}	
	
//	@Around("execution(public String DoSomething())")
//	public void AroundLogging() {
//		System.out.println(" ====>  Around Logged");
//	}
//	 // Console outout only " ====>  Around Logged" 
//	 // Browser didnt show any output,ie didn't call the execution
	
	@Before ("execution(public String DoSomething())")
	public void BeforeLogging() {
		System.out.println(" ====>  Before Logged");
	}
	
}

