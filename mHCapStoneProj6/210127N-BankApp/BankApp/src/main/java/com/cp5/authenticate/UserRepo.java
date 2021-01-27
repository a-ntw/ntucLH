package com.cp5.authenticate;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<Myusers, Long>{
	
	Myusers findByUsername(String username);

}
