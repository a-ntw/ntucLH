package com.cp6.auth;

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
		
		@Column
		private String username;
		
		@Column
		private String password;

		public Users() {}
		
		public Users(String username, String password) {
			this.username = username;
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

		public void setPassword(String password) {
			this.password = password;
		}

		public Set<Roles> getRoles() {
			return roles;
		}

		public void setRoles(Set<Roles> roles) {
			this.roles = roles;
		}

		//
		public void addRole(Roles role) {
			this.roles.add(role);
		}
		
		public void removeRole(Roles role) {
			this.roles.remove(role);
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