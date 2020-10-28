package in.conceptarchitect.banking.tests;

import static in.conceptarchitect.utils.CustomAsserts.assertType;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import in.conceptarchitect.banking.BankAccount;
import in.conceptarchitect.banking.OverDraftAccount;

public class OverdraftAccountTests {

	String password="pass";
	double balance=10000;
	OverDraftAccount account;
	
	@Before
	public void init() {
		account=new OverDraftAccount("some name",password, balance);
		
	}
	
	@Test
	public void account_isATypeOfSavingAccount() {
		assertType(BankAccount.class, account);
		
	}
	
	private void assertOdLimit(double expectedOdLimit) {
		assertEquals(expectedOdLimit, account.getOdLimit(),0.01);
	}
	
	
	@Test
	public void account_hasOdLimitAs10PercentOfInitialDeposit() {
		
		double expectedOdLimit= balance*0.1;
		
		
		//assertEquals(expectedOdLimit,account.getOdLimit(),0.01);
		
		assertOdLimit(expectedOdLimit);
		
		
		
	}
	
	//@Ignore 
	@Test
	public void odLimit_increasesOdLimitIfBalanceIncreasesToHistoricHightestValue() {
		double extra=10000;
		account.deposit(extra); //now balance becomes balance+extra
		
		double newOdLimit=(extra+balance)*0.1;
		
		assertOdLimit(newOdLimit);
	}
	
	//@Ignore
	@Test
	public void odLimit_doesntChangeOnWithdrawal() {
		
		double odLimitBeforeWithdrawal=account.getOdLimit();
		
		account.withdraw(5000, password);
		
		
		assertOdLimit(odLimitBeforeWithdrawal);
	}
	
	
	@Test
	public void odLimit_canIncreaseIfCreditInterestIncreasesAccountBalanceUptoHistoricMax() {
		
		account.creditInterest(12);
		double newBalance= account.getBalance();
		double expectedOdLimit=newBalance*0.1;
		
		assertOdLimit(expectedOdLimit);
		
	}
	
	@Ignore
	@Test
	public void odLimit_doesntChangeIfNewBalanceIsLessThanHistoricMaxBalance() {
		fail("Implement the logic here");
	}
	

	@Ignore
	@Test
	public void withdraw_canWithdrawUptoBalancePlusOdLimit() {
		fail("Implement the logic here");
	}

	@Ignore
	@Test
	public void withdraw_canPushMyBalanceToNegative() {
		fail("Implement the logic here");
	}
	
	@Ignore
	@Test
	public void withdraw_overlimitAttracts1PCOdFee() {
		fail("Implement the logic here");
	}
	
	
	
	
	
	
}
