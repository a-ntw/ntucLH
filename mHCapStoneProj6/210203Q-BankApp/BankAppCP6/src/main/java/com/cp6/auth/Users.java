package com.cp6.auth;

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

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Entity
public class Users {

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Integer id;
		
		@Column
		private String username;
		
		@Column
		private String password;

		public Users() {}
		
		public Users(String username, String password) {
			this.username = username;
			this.password = password;
		}

		// was @ManyToMany
		// cascade , fetch added for IserDetailImpt/UserRole
		@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
		@JoinTable(
				name = "user_roles",
				joinColumns = @JoinColumn(name = "user_id"),
				inverseJoinColumns = @JoinColumn(name = "role_id")
				)
		
		private Set<Roles> userRoles = new HashSet<>();
		
		
		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
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

		// 210207 only add this to send BCryptPass to database
		public void setPassword(String password) {
//			this.password = password;
			BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
			this.password = passwordEncoder.encode(password);
		}

		public Set<Roles> getRoles() {
			return userRoles;
		}

		public void setRoles(Set<Roles> userRoles) {
			this.userRoles = userRoles;
		}

		//
		public void addRole(Roles role) {
			this.userRoles.add(role);
		}
		
		public void removeRole(Roles role) {
			this.userRoles.remove(role);
		}
		
//		@Override
//		public String toString() {
//			return "Myusers [id=" + id + ", username=" + username + ", password=" + password + "]";
//		}

		
}
/*
REM INSERTING into savari.USERS
SET DEFINE OFF;
Insert into savari.USERS (USERNAME,PASSWORD) values ('simon','$2y$12$PPrZxxCGwaOAtO/lqS5g3e6ft9Oi6tLN1mgwQuHu2y9bGVeG.pYMC');
Insert into savari.USERS (USERNAME,PASSWORD) values ('ntuc','$2y$12$OlRxs83PvNA.LuDKQngubuZFWXKg4IBd19xyXt43KD9WQeNGx55VW');
Insert into savari.USERS (USERNAME,PASSWORD) values ('password','$2y$12$FaKrkyaHn18dGpPUQ.md/ec86MTUuaAZyugfJ6YV8Qz2h/I06MLwm');
*/
/*
https://bcrypt-generator.com/
*/