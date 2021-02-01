package springbeanscope;

import java.util.Date;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

@Component
@Scope(value = WebApplicationContext.SCOPE_SESSION,proxyMode = ScopedProxyMode.TARGET_CLASS)
public class SessionScopeBean {
	
	private Date Currdate;

	public SessionScopeBean(Date date) {
		super();
		this.Currdate = date;
	}
	
	public SessionScopeBean() {
		Currdate = new Date();
	}

	public Date getCurrDate() {
		return Currdate;
	}

	public void setCurDate(Date date) {
		this.Currdate = date;
	}
	
	
}
