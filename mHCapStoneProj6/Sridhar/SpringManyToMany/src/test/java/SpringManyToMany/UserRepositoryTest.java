package SpringManyToMany;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class UserRepositoryTest {

	@Autowired
	private UsersRepository repo;
	
	@Autowired
	private TestEntityManager entityManager;
	
	@Test
	public void test() {
	}
	
	@Test
	public void TestCreationOfRoles() {
	Roles roleAdmin = new Roles("Administrator");
	Roles rolesManager = new Roles("Manager");
	Roles rolesUser = new Roles("User");
	
	entityManager.persist(roleAdmin);
	entityManager.persist(rolesManager);
	entityManager.persist(rolesUser);
	
	}
	
	@Test
	public void TestCreationOfUsersWithOneRole() {
		Roles roleAdmin = entityManager.find(Roles.class,1);
		Users user = new Users("ntuc2021@test.com","ntuc2021");
		user.addRole(roleAdmin);
		
		repo.save(user);
	}
	
	@Test
	public void TestCreationOfUsersWithTwoRoles() {
		Roles rolesUser = entityManager.find(Roles.class,3);
		Roles rolesManager = entityManager.find(Roles.class,2);
		Users user = new Users("simon@test.com","simon2020");
		user.addRole(rolesUser);
		user.addRole(rolesManager);
		
		repo.save(user);
	}
	
	@Test
	public void TestCreationOfRoleToExistingUser() {
		Users user = repo.findById(1).get();
		Roles rolesUser = entityManager.find(Roles.class,3);
			user.addRole(rolesUser);
			
			
	}
	
	
	@Test
	public void RemoveRoleFromUser() {
		Users user = repo.findById(1).get();
		long l=3;
		Roles roles = new Roles(l);
		user.removeRole(roles);
	}
	
	@Test
	public void testCreateNewUserAndNewRole() {
		Roles roleSales = new Roles("salesPrson");
		Users user = new Users("john@test.com","john123");
		user.addRole(roleSales);
		
		repo.save(user);
	}
	
//	@Test
//	public void testGetUser() {   // to enable this we will have to set the (cascade = CascadeType.PERSIST, fetch = FetchType.EAGER) on the relation
//		Users user = repo.findById(1).get();
//		entityManager.detach(user);
//		System.out.println(user.getEmail());
//		System.out.println(user.getRoles());
//	}
	
	@Test
	public void removeUser() {
		repo.deleteById(11);
		
	}
	
	}
	

