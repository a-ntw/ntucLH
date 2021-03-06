testing, jpaRepository
===

210202Test.png <img src="210202Test.png">

[ UserRepositoryTest.java ]( UserRepositoryTest.java)

#### Roles.java
``` java
@Entity
public class Roles {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(length = 55, nullable = false, unique = true)
	private String name;

	public Roles() {}
	...
```

#### Users.java
``` java
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
```

#### UserController.java
``` java
@Controller
public class UserController {

	@Autowired
	private UsersRepository repo;
	
	@Autowired
	private RoleRepository rolerepo;
	
	@RequestMapping("/users")
	public String ShowUsersList(Model model) {
		java.util.List<Users> listUsers = repo.findAll();
		model.addAttribute("listUsers", listUsers);
		
		return "users";
	}
	...
```

#### index.html
``` html
	<div class="container text-center">
		<div class="p-2">
			<a class="h2" th:href="@{/users}"> List Users </a>
		</div>

		<div class="p-2">
			<a class="h2" th:href="@{/users/new}"> Create Users </a>
		</div>
	</div>
```

#### users.html
``` html
<H1>User List</H1>
	<div>
		<h3>
			<a th:href="@{/users/new}"> Create New User</a>
		</h3>
	</div>

	<table>
		<thead>
			<tr>
				<th>ID</th>
				<th>Email</th>
				<th>Roles</th>
			</tr>
		</thead>

		<tbody>
			<th:block th:each="users: ${listUsers}">
				<tr>
					<td>[[${users.id}]]</td>
					<td>[[${users.email}]]</td>
					<td>[[${users.roles}]]]</td>
					<td><a th:href="@{'/users/edit/' + ${users.id}}"> Edit </a></td>
					<td><a th:href="@{'/users/delete/' + ${users.id}}"> Delete
					</a></td>
				</tr>
			</th:block>
		</tbody>
	</table>
```

#### UserRepositoryTest.java
``` java
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
		Roles roleAdmin = entityManager.find(Roles.class, 1);
		Users user = new Users("guzzu@test.com", "test2020");
		user.addRole(roleAdmin);

		repo.save(user);
	}

	@Test
	public void TestCreationOfUsersWithTwoRoles() {
		Roles rolesUser = entityManager.find(Roles.class, 3);
		Roles rolesManager = entityManager.find(Roles.class, 2);
		Users user = new Users("simon@test.com", "simon2020");
		user.addRole(rolesUser);
		user.addRole(rolesManager);

		repo.save(user);
	}

```

#### CategoryRepositorTestDataBase.java
ref: SpringManyToMany dated 2 Feb 2021. To test database on Save and Delete 
``` java
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import com.ntuc.model.Category;
import com.ntuc.repository.CategoryRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class CategoryRepositorTestDatabase {
	
	@Autowired
	private CategoryRepository repo;

	@Test
	public void testAddDelCategory() {
		Category savedCategory = 	repo.save(new Category("Televisions"));
		assertThat(savedCategory.getId()).isGreaterThan(0);
		
		repo.deleteById(savedCategory.getId());
		Boolean CatPresence =  repo.existsById(savedCategory.getId());
		assertThat(CatPresence).isFalse();
	}
}

```
#### BankAppCP6/UserRepositoryTest.java
``` java
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class UserRepositoryTest {

	@Autowired
	private UsersRepository repo;

	@Autowired
	private TestEntityManager entityManager;
	
	...
	
	/* TestCreationOfUsersWithTwoRoles, Create new user with 2 roles */
	/* myRemoveRoleFromUser, Identify existing user and removed its 2 roles */
	/* removeUser,Delete existing user with no role */
	@Test
	public void CreateAndDeleteUserWRoles() {
		TestCreationOfUsersWithTwoRoles();
		myRemoveRoleFromUser();
		removeUser();
	}
	//	@Test
	private void TestCreationOfUsersWithTwoRoles() {
		Roles rolesUser = entityManager.find(Roles.class, 3);
		Roles rolesManager = entityManager.find(Roles.class, 2);
		Users user = new Users("test@test.com", "test123");
		user.addRole(rolesUser);
		user.addRole(rolesManager);
		repo.save(user);
	}
	//	@Test
	private void myRemoveRoleFromUser() {
		Users user = repo.findByUsername("test@test.com");
		Roles roles = new Roles(3);
		user.removeRole(roles);
		roles = new Roles(2);
		user.removeRole(roles);
	}
	//	@Test
	private void removeUser() {
		Users user = repo.findByUsername("test@test.com");
		
		repo.deleteById(user.getId()); // need to remove roles, prior to delete
	}
```


---
