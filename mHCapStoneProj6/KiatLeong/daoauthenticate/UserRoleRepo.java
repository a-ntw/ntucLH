package com.cp5.daoauthenticate;

import org.springframework.data.repository.CrudRepository;

public interface UserRoleRepo extends CrudRepository<UserRole, Long> {
	UserRole findByName(String name);
}
