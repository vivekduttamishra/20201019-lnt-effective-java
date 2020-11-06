package in.conceptarchitect.banking.atmapp;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import config.BankTestConfig;
import in.conceptarchitect.banking.core.Bank;
import in.conceptarchitect.banking.exceptions.InvalidAccountNumberException;
import in.conceptarchitect.banking.repository.HashmapAccountRepository;

public class BankTests {

	Bank bank;
	ApplicationContext context;
	
	@Before
	public void setUp() throws Exception {
		context=new AnnotationConfigApplicationContext(BankTestConfig.class);
		bank=context.getBean(Bank.class);
	}

	@Test
	public void bankShouldExist() {
		assertNotNull(bank);
	}
	
	@Test
	public void bankUsesHashMapRepository() {
		assertTrue(bank.getAccounts() instanceof HashmapAccountRepository);
	}
	
	@Test
	public void canDepositFundsToActiveAccount() {
		bank.deposit(1, 1000);
	}
	
	@Test(expected = InvalidAccountNumberException.class )
	public void depositThrowsInvalidAccountNumberExeptionForInvalidAccount() {
		bank.deposit(1000, 1000);
	}

}





