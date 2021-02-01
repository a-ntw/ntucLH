package springbeanscope;

import java.util.Date;


import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

@Component
@Scope(value = WebApplicationContext.SCOPE_REQUEST,proxyMode = ScopedProxyMode.TARGET_CLASS)
public class RequestScopeBean {
	
	private Date Currdate;

	public RequestScopeBean(Date date) {
		this.Currdate = date;
	}

	public RequestScopeBean() {
		Currdate = new Date();
	}

	public Date getCurrDate() {
		return Currdate;
	}

	public void setCurrDate(Date date) {
		this.Currdate = date;
	}
	
	
}
