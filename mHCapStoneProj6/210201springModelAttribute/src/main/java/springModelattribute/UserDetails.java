package springModelattribute;

import java.io.Serializable;

import org.springframework.stereotype.Component;

@Component
public class UserDetails implements Serializable{
	
	private String username;
	private String email;
	private int id;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "UserDetails [username=" + username + ", email=" + email + ", id=" + id + "]";
	}
	
	

}
