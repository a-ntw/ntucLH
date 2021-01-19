package ntuc;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class logging {
	@Before("execution(public String DoSomething())")
	public void DoLogging() {
		System.out.println("Logged");
	}
}
