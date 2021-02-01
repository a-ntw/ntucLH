package springbeanscope;

import java.util.Date;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

@Component
@Scope(value = WebApplicationContext.SCOPE_APPLICATION,proxyMode = ScopedProxyMode.TARGET_CLASS)
public class ApplicationScopeBean {
	
	private Date Currdate;

	public ApplicationScopeBean(Date date) {
		super();
		this.Currdate = date;
	}
	
	public ApplicationScopeBean() {
		Currdate = new Date();
	}

	public Date getCurrDate() {
		return Currdate;
	}

	public void setCurrDate(Date date) {
		this.Currdate = date;
	}
}
