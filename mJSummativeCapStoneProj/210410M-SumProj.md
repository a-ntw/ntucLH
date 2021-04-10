## @test hireRepo assertEquals assertThat copiedArray
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
	
	@Test
	public void copiedArray() {
		Vehicle veh  = new Vehicle();
		//vehRepo.findById((long) 5); // result: null 
		List<Vehicle> listVeh = vehRepo.findAll();

		veh = listVeh.get(0); // let say 0		
		List<Hire> listHires =  hireRepo.findAllByVehicle(veh);
		assertThat(listHires).isNotNull();
		
		List<Booking> listBooks = new ArrayList<>();
		
		for (Hire h : listHires) {
			Booking b = new Booking();
			b.setDateEnd(h.getDateEnd());
			b.setDateStart(h.getDateStart());
			b.setCustomer(h.getCustomer());
			b.setVehicle(h.getVehicle());
			listBooks.add(b);
		}

		for (Booking b: listBooks) {
			System.out.println("=====> b startDate: " + b.getDateStart());
		}
		assertThat(listBooks).isNotNull();
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
