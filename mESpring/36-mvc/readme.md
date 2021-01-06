Spring Web Introduction
===
[top]: topOfThePage

| Layer | ClassName | Annotation |  |
| ---: | --- | --- | --- |
| Web//REST | AccountController   | @RestController, @Controller     |    |
| Service    | AccountService  |  @Service  (@Transactional, @PreAuthorize     |    |
| Repository     | AccountRepository  | @Repository (uses JdbcTemplate) |    |
| Infrastructure     | DataSource   |      |    |
|      |   |      |    |
|      |   |      |    |
| Domain Object    | Account  |  POJO (SpringData:@Id, JPA:@Entity    |    |
|      |   |      |    |
| Config Class     | AppConfig, InfraConfig  | @Configuration     |    |
| Main Class    | ???Application  | @SpringBootApplication     |    |
|      |   |      |    |


[:top: Top](#top)

---
[**myNote**](mynote.md)

---
