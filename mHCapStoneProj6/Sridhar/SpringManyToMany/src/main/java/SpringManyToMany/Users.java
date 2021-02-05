package SpringManyToMany;

import java.util.HashSet;


import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Users {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	

	@Column(length = 55, nullable = false, unique = true)
	private String email;
	

	@Column(length = 15, nullable = false)
	private String password;
	
	
	
	public Users() {}
	
	public Users(String email, String password) {
		this.email = email;
		this.password = password;
	}

	@ManyToMany
	@JoinTable(
			name = "user_roles",
			joinColumns = @JoinColumn(name = "user_id"),
			inverseJoinColumns = @JoinColumn(name = "role_id")
			)
	
	private Set<Roles> roles = new HashSet<>();
	

	public Integer getId() {
		return id;
	}

	public Set<Roles> getRoles() {
		return roles;
	}

	public void setRoles(Set<Roles> roles) {
		this.roles = roles;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public void addRole(Roles role) {
		this.roles.add(role);
	}
	
	public void removeRole(Roles role) {
		this.roles.remove(role);
	}

	
	

}
