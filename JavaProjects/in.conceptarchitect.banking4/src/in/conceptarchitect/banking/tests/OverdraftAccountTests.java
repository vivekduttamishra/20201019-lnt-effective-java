package in.conceptarchitect.banking.tests;

import static org.junit.Assert.fail;

import org.junit.Test;

public class OverdraftAccountTests {


	@Test
	public void account_hasOdLimitAs10PercentOfInitialDeposit() {
		fail("Implement the logic here");
	}
	
	@Test
	public void odLimit_increasesOdLimitIfBalanceIncreasesToHistoricHightestValue() {
		fail("Implement the logic here");
	}
	
	@Test
	public void odLimit_doesntChangeOnWithdrawal() {
		fail("Implement the logic here");
	}
	
	@Test
	public void odLimit_canIncreaseIfCreditInterestIncreasesAccountBalanceUptoHistoricMax() {
		fail("Implement the logic here");
	}
	
	@Test
	public void odLimit_doesntChangeIfNewBalanceIsLessThanHistoricMaxBalance() {
		fail("Implement the logic here");
	}
	
		
	@Test
	public void withdraw_canWithdrawUptoBalancePlusOdLimit() {
		fail("Implement the logic here");
	}

	@Test
	public void withdraw_canPushMyBalanceToNegative() {
		fail("Implement the logic here");
	}
	
	@Test
	public void withdraw_overlimitAttracts1PCOdFee() {
		fail("Implement the logic here");
	}
	
	
	
	
	
	
}
