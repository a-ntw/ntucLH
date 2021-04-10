## Test hireRepo 
fyi, mac short keys for `Run As Test` > Option + Command + X then T
#### bookingTest.java
``` java
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class bookingTest {
	
	@Autowired
	private HireRepo hireRepo;

	//@Disabled
	@Test
	public void testing() {
		int a = 1;
		assertEquals(a, 1);
	}


	@Test
	public void hireGetTest() {
		List<Hire> listHires =  hireRepo.findAll();
		assertThat(listHires).isNotNull();
		
		Hire hire = listHires.get(1);
		assertThat(hire).isNotNull();
	}
	
	LocalDateArrayMany lda;
	@Test
	public void checkValidDates() {
		LocalDate s= LocalDate.now();
		LocalDate e = s.plusDays(5);
		assertEquals(lda.checkValidDates(s,e), true);
		assertEquals(lda.checkValidDates(s,s), true);
		assertEquals(lda.checkValidDates(e,e), true);
		assertEquals(lda.checkValidDates(e,s), false);
	}
}
```
#### LocalDateArrayMany.java
``` java
	public static boolean checkValidDates(LocalDate start, LocalDate end) {
		if (end.isBefore(start)) {return false;}
		
		return true;
	}
```
---
