package com.cp5.daoauthenticate;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Entity
@Table(name = "users")
public class Users implements Serializable {

		@Id
		@Column(name = "user_id")
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private long id;
		private String username;
		private String password;
		private boolean enabled;
		
		@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
		@JoinTable( name ="users_roles",
					joinColumns = @JoinColumn(name = "user_id"),
					inverseJoinColumns = @JoinColumn(name = "role_id"))
		
		private Set<UserRole> userRoles = new HashSet<>();
		
		public long getId() {
			return id;
		}
		public void setId(long id) {
			this.id = id;
		}
		public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
			this.password = passwordEncoder.encode(password);
		}		
		public boolean isEnabled() {
			return enabled;
		}
		public void setEnabled(boolean enabled) {
			this.enabled = enabled;
		}
		public Set<UserRole> getUserRoles() {
			return userRoles;
		}
		public void setUserRoles(Set<UserRole> userRoles) {
			this.userRoles = userRoles;
		}
		@Override
		public String toString() {
			return "Users [id=" + id + ", username=" + username + ", password=" + password + "]";
		}
		
		
}
