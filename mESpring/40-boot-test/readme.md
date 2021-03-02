#### AccountClientTests.java
``` java
package accounts.client;

import common.money.Percentage;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import rewards.internal.account.Account;
import rewards.internal.account.Beneficiary;

import java.net.URI;
import java.util.Random;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

// TODO-00: In this lab, you are going to exercise the following:
// - Using @SpringBootTest and webEnvironment for end-to-end testing
//   (You are going to refactor the test code of previous lab of "38-rest-ws"
//    to use Spring Boot test framework.)
// - Understanding the different usage model of TestRestTemplate from RestTemplate
//    * Usage of a relative path rather than an absolute path
//    * Handling the 404 response from the service
// - Using MockMvc for Web slice testing
// - Understanding the difference between @MockBean and @Mock

// TODO-01: Make this class a Spring Boot test class
// - Add @SpringBootTest annotation with WebEnvironment.RANDOM_PORT

@SpringBootTest (webEnvironment = WebEnvironment.RANDOM_PORT) //
public class AccountClientTests {

	// TODO-02: Autowire TestRestTemplate bean to a field
	// - Name the field as restTemplate
	
	@Autowired
	private TestRestTemplate restTemplate;

	// TODO-03: Update code below to use TestRestTemplate (as opposed to RestTemplate)
	// - Remove RestTemplate from this code
	// - Remove BASE_URL from this code or change the value of it to ""
	// - Run the tests and observe that they pass except
	//   "addAndDeleteBeneficiary" test
	//   (If you are using Gradle, remove test exclude statement
	//    from the build.gradle before running these tests)

	/**
	 * server URL ending with the servlet mapping on which the application can be
	 * reached.
	 */
//	private static final String BASE_URL = "http://localhost:8080";
	private static final String BASE_URL = "";

//	private RestTemplate restTemplate = new RestTemplate();
	private Random random = new Random();

	@Test
	public void listAccounts() {
//		String url = BASE_URL + "/accounts";
		String url = "/accounts";
		// we have to use Account[] instead of List<Account>, or Jackson won't know what
		// type to unmarshal to
		Account[] accounts = restTemplate.getForObject(url, Account[].class);
		assertThat(accounts.length >= 21).isTrue();
		assertThat(accounts[0].getName()).isEqualTo("Keith and Keri Donald");
		assertThat(accounts[0].getBeneficiaries().size()).isEqualTo(2);
		assertThat(accounts[0].getBeneficiary("Annabelle").getAllocationPercentage()).isEqualTo(Percentage.valueOf("50%"));
	}

	@Test
	public void getAccount() {
		String url = BASE_URL + "/accounts/{accountId}";
		Account account = restTemplate.getForObject(url, Account.class, 0);
		assertThat(account.getName()).isEqualTo("Keith and Keri Donald");
		assertThat(account.getBeneficiaries().size()).isEqualTo(2);
		assertThat(account.getBeneficiary("Annabelle").getAllocationPercentage()).isEqualTo(Percentage.valueOf("50%"));
	}

	@Test
	public void createAccount() {
		String url = BASE_URL + "/accounts";
		// use a random account number to avoid conflict
		String number = String.format("12345%4d", random.nextInt(10000));
		Account account = new Account(number, "John Doe");
		account.addBeneficiary("Jane Doe");
		URI newAccountLocation = restTemplate.postForLocation(url, account);

		Account retrievedAccount = restTemplate.getForObject(newAccountLocation, Account.class);
		assertThat(retrievedAccount.getNumber()).isEqualTo(account.getNumber());

		Beneficiary accountBeneficiary = account.getBeneficiaries().iterator().next();
		Beneficiary retrievedAccountBeneficiary = retrievedAccount.getBeneficiaries().iterator().next();

		assertThat(retrievedAccountBeneficiary.getName()).isEqualTo(accountBeneficiary.getName());
		assertThat(retrievedAccount.getEntityId()).isNotNull();
	}

	// TODO-04: Modify the code below so that it handles 404 HTTP response status
	//          from the server (instead of handling it as an exception as in the
	//          case of RestTemplate)
	// - Remove the "assertThrows" statement (since you are not going to
	//   check if an exception is thrown)
	// - Use "getForEntity" method (instead of "getForObject" method) of
	//   "TestRestTemplate"
	// - Verify that the HTTP response status is 404
	// - Run all tests - they should all pass
	@Test
	public void addAndDeleteBeneficiary() {
		// perform both add and delete to avoid issues with side effects
		String addUrl = BASE_URL + "/accounts/{accountId}/beneficiaries";
		URI newBeneficiaryLocation = restTemplate.postForLocation(addUrl, "David", 1);
		Beneficiary newBeneficiary = restTemplate.getForObject(newBeneficiaryLocation, Beneficiary.class);
		assertThat(newBeneficiary.getName()).isEqualTo("David");

		restTemplate.delete(newBeneficiaryLocation);

//		HttpClientErrorException httpClientErrorException = assertThrows(HttpClientErrorException.class, () -> {
//			System.out.println("You SHOULD get the exception \"No such beneficiary with name 'David'\" in the server.");
//			restTemplate.getForObject(newBeneficiaryLocation, Beneficiary.class);
//		});
//		assertThat(httpClientErrorException.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
		
		//
		ResponseEntity<Beneficiary> response =
				restTemplate.getForEntity(newBeneficiaryLocation, Beneficiary.class);
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
	}

	// TODO-05: Observe a log message in the console indicating
	//          Tomcat started as part of testing
	// - Search for "Tomcat started on port(s):"
	// - Note how long it takes for this test to finish - it is
	//   in the range of several seconds

}

```


#### AccountControllerBootTests.java
``` java
package accounts.web;

import com.fasterxml.jackson.databind.ObjectMapper;

import accounts.AccountManager;
import common.money.Percentage;
import rewards.internal.account.Account;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureDataJpa;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

// TODO-06: Get yourself familiarized with various testing utility classes
// - Uncomment the import statements below
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.*;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.Arrays;
import java.util.List;

// TODO-07: Replace @ExtendWith(SpringExtension.class) with the following two annotations
// - @WebMvcTest(AccountController.class) // includes @ExtendWith(SpringExtension.class)
// - @AutoConfigureDataJpa
//@ExtendWith(SpringExtension.class)
@AutoConfigureDataJpa
@WebMvcTest(AccountController.class)
public class AccountControllerBootTests {

	// TODO-08: Autowire MockMvc bean
	@Autowired
	private MockMvc mockMvc;

	// TODO-09: Create AccountManager mock bean using @MockBean annotation
	@MockBean
	private AccountManager accountManager;

	// TODO-10: Write positive test for GET request for an account
	// - Uncomment the code and run the test and verify it succeeds
	@Test
	public void accountDetails() throws Exception {

		// arrange
		given(accountManager.getAccount(0L))
				.willReturn(new Account("1234567890", "John Doe"));

		// act and assert
		mockMvc.perform(get("/accounts/0"))
			   .andExpect(status().isOk())
			   .andExpect(content().contentType(MediaType.APPLICATION_JSON))
			   .andExpect(jsonPath("name").value("John Doe"))
			   .andExpect(jsonPath("number").value("1234567890"));

		// verify
		verify(accountManager).getAccount(0L);

	}

	// TODO-11: Write negative test for GET request for a non-existent account
	// - Uncomment the "given" and "verify" statements
	// - Write code between the "given" and "verify" statements
	// - Run the test and verify it succeeds
	@Test
	public void accountDetailsFail() throws Exception {

		given(accountManager.getAccount(any(Long.class)))
				.willThrow(new IllegalArgumentException("No such account with id " + 0L));

		// (Write code here)
		// - Use mockMvc to perform HTTP Get operation using "/accounts/9999"
        //   as a non-existent account URL
		// - Verify that the HTTP response status is 404
		mockMvc.perform(get("/accounts/9999"))
			.andExpect(status().isNotFound());

		verify(accountManager).getAccount(any(Long.class));

	}

    @Test
    public void accountSummary() throws Exception {

        List<Account> testAccounts = Arrays.asList(new Account("123456789", "John Doe"));
        given(accountManager.getAllAccounts())
				.willReturn(testAccounts);

        mockMvc.perform(get("/accounts"))
               .andExpect(status().isOk())
               .andExpect(content().contentType(MediaType.APPLICATION_JSON))
               .andExpect(jsonPath("$..number").value("123456789"))
               .andExpect(jsonPath("$..name").value("John Doe"));

        verify(accountManager).getAllAccounts();

    }
	
    // TODO-12: Write test for `POST` request for an account
	// - Uncomment Java code below
	// - Write code between the "given" and "verify" statements
	// - Run the test and verify it succeeds
	@Test
	public void createAccount() throws Exception {

		Account testAccount = new Account("1234512345", "Mary Jones");
		testAccount.setEntityId(21L);

		given(accountManager.save(any(Account.class)))
				.willReturn(testAccount);

		// (Write code here)
		// Use mockMvc to perform HTTP Post operation to "/accounts"
		// - Set the request content type to APPLICATION_JSON
		// - Set the request content with Json string of the "testAccount"
		//   (Use "asJsonString" method below to convert the "testAccount"
		//   object into Json string)
		// - Verify that the response status is 201
		// - Verify that the response "Location" header contains "http://localhost/accounts/21"

        mockMvc.perform(post("/accounts")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(testAccount)))
   .andExpect(status().isCreated())
   .andExpect(header().string("Location", "http://localhost/accounts/21"));
        
		verify(accountManager).save(any(Account.class));

	}


    @Test
    public void addBeneficiary() throws Exception {

        mockMvc.perform(post("/accounts/{entityId}/beneficiaries", 0L)
				            .content("Kate"))
               .andExpect(status().isCreated())
               .andExpect(header().string("Location", "http://localhost/accounts/0/beneficiaries/Kate"));
    }

    @Test
    public void removeBeneficiary() throws Exception {

        Account account = new Account("1234567890", "John Doe");
        account.addBeneficiary("Corgan", new Percentage(0.1));
        given(accountManager.getAccount(anyLong())).willReturn(account);

        mockMvc.perform(delete("/accounts/{entityId}/beneficiaries/{name}", 0L, "Corgan"))
               .andExpect(status().isNoContent());

        verify(accountManager).getAccount(anyLong());

    }

    @Test
    public void removeBeneficiaryFail() throws Exception {
        Account account = new Account("1234567890", "John Doe");
        given(accountManager.getAccount(anyLong())).willReturn(account);

        mockMvc.perform(delete("/accounts/{entityId}/beneficiaries/{name}", 0L, "Noname"))
               .andExpect(status().isNotFound());

        verify(accountManager).getAccount(anyLong());
    }
	
	
    // Utility class for converting an object into JSON string
	protected static String asJsonString(final Object obj) {
		try {
			final ObjectMapper mapper = new ObjectMapper();
			final String jsonContent = mapper.writeValueAsString(obj);
			return jsonContent;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	// TODO-13 (Optional): Experiment with @MockBean vs @Mock
	// - Change `@MockBean` to `@Mock` for the `AccountManager dependency above
	// - Run the test and observe a test failure
	// - Change it back to `@MockBean`

}

```
