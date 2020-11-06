package in.conceptarchitect.banking.atmapp;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import config.BankTestConfig;
import in.conceptarchitect.banking.core.Bank;
import in.conceptarchitect.banking.exceptions.InvalidAccountNumberException;
import in.conceptarchitect.banking.repository.HashmapAccountRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=BankTestConfig.class)
public class BankSpringTest {

	@Autowired Bank bank;
	
	
	@Before
	public void setUp() throws Exception {
	
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





