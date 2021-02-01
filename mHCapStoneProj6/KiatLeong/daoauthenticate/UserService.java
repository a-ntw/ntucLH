package com.cp5.daoauthenticate;

import java.util.Arrays;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	@Autowired
	UserRepo userRepo;
	
	@Autowired
	UserRoleRepo roleRepo;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	public UserService(UserRepo userRepo) {
		this.userRepo = userRepo;
	}
	
	public void saveUser(Users user) {
		user.setUserRoles(Set.of(roleRepo.findByName("USER")));		
		user.setEnabled(true);
		userRepo.save(user);
	}
	
	public void saveAdmin(Users user) {
		user.setUserRoles(Set.of(roleRepo.findByName("ADMIN")));
		user.setEnabled(true);
		userRepo.save(user);
	}

	public Page<Users> findPageinated(int pageNo, int pageSize, String keyword, String sortField,
			String sortDirection) {
		Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending()
				: Sort.by(sortField).descending();
		Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
		if (keyword !=null) {
			return userRepo.search(keyword, pageable);
		}	
		return userRepo.findAll(pageable);
	}

	public void deleteUserById(long userId) {
		userRepo.deleteById(userId);
		
	}
}
