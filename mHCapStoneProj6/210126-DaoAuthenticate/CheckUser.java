package daoauthenticate;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

@Aspect
@Component
public class CheckUser {
	
	private Object principal;
	private String user;
	
	@Around("execution(public String TestAop(..))")
	public String checkLoggerUser(ProceedingJoinPoint joinpoint) throws Throwable {
		
		principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		System.out.println(" ====>> CheckUser >> " + principal);
		
		if (principal instanceof UserDetails) {
			user = ((UserDetails) principal).getUsername();
		} else {
			user = principal.toString();
		}

		if (user.equals("ntuc")) {
			System.out.println("success");
			return "redirect:/error.html";
		}
		else {
			System.out.println("not success");
			return (String)joinpoint.proceed();
		}
			
	}

}
/* console
 ====>> CheckUser >> daoauthenticate.UserDetailImpl@7a2a6968
success

 ====>  UserControl
 ====>> CheckUser >> daoauthenticate.UserDetailImpl@694c7da3
not success
 * */
