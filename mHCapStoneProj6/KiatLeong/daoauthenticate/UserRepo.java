package com.cp5.daoauthenticate;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepo extends JpaRepository<Users, Long> {
	
	@Query("SELECT u FROM Users u WHERE u.username = :username")
	public Users getUserByUserName(@Param("username")String username);

//	@Query("select u.id, u.username, u.enabled, r.name \r\n"
//			+ "from Users u join users_roles ur\r\n"
//			+ "on u.id=ur.id\r\n"
//			+ "join roles r\r\n"
//			+ "on ur.ROLE_ID = r.ROLE_ID WHERE CONCAT(u.user_id, ' ', u.username) LIKE %?1%")
	@Query("SELECT u FROM Users u WHERE CONCAT(u.id, ' ', u.username) LIKE %?1%")
	public Page<Users> search(String keyword, Pageable pageable);
	
//	@Query("select u.id, u.username, u.enabled, r.id from Users u, Users_Roles r ")
	public Page<Users> findAll(Pageable pageable);
	
}
