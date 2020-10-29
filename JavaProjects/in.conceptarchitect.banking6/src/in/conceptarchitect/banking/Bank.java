package in.conceptarchitect.banking;

import in.conceptarchitect.banking.exceptions.InsufficientBalanceException;
import in.conceptarchitect.banking.exceptions.InvalidAccountNumberException;

public class Bank {
	
	int accountCount=0;   	
	String name;
	double interestRate;
	public final int MAX_ACCOUNTS=10; //PROBLEM: we can't have more than this much account
	
	//storage for BankAccounts
	BankAccount [] accounts=new BankAccount[MAX_ACCOUNTS];
	
	private int addAccount(BankAccount account) {
		//add the account to account list		
		//account number x will be stored on location x
		//we will never use index 0 to store a account
		getAllAccounts()[account.accountNumber]=account;  //add all accounts to the same collection
		
		//return the account Number
		return account.accountNumber;
	}
	
	private BankAccount getAccountById(int accountNumber) {
		if(accountNumber<1 || accountNumber>accountCount || getAllAccounts()[accountNumber]==null)
			//return null; //no such account
			throw new InvalidAccountNumberException(accountNumber);
		
		BankAccount account=getAllAccounts()[accountNumber];
		return account;
	}
	
	private void removeAccount(int accountNumber) {
		getAllAccounts()[accountNumber]=null; //remove the account
	}
	
	private BankAccount[] getAllAccounts() {
		return accounts;
	}
	
	
	
	public Bank(String name, double interstRate) {
	
		this.interestRate=10;
		this.name=name;
		
		
	}
	
	public double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}

	public int getAccountCount() {
		return accountCount;
	}

	public String getName() {
		return name;
	}
	
	
	
	public void deposit(int accountNumber, double amount) {
		BankAccount account = getAccountById(accountNumber);
		account.deposit(amount);
	}
	
	
	public int openAccount(String accountType,String name, String password,  double amount) {
		
		BankAccount account=null;
		
		
		switch(accountType.toLowerCase()) {
		
			default: case "savings": account=new SavingsAccount(name,password,amount);break;
			case "current": account=new CurrentAccount(name,password,amount);break;
			//case "overdraft":account=new OverDraftAccount(name,password,amount); break;
		}
		
		
		
		//Bank should set the account Number which is accessible due to package scope
		account.accountNumber=++accountCount;
		
		return addAccount(account);
	}

	public void close(int accountNumber, String password) {
		BankAccount account = getAccountById(accountNumber);
		
		account.authenticate(password);
				
		
		if(account.getBalance()<0)
			throw new InsufficientBalanceException(accountNumber, -account.getBalance()," You need to clear the overdue to close your account");
		
		
		removeAccount(accountNumber);

	}


	public void withdraw(int accountNumber, double amount, String password) {
		BankAccount account = getAccountById(accountNumber);
		account.withdraw(amount, password); //may return success or falure
	}
	
	
	public void transfer(int sourceAccountNumber,  double amount, String password,int targetAccountNumber) {
		
		BankAccount target=getAccountById(targetAccountNumber);
		BankAccount src = getAccountById(sourceAccountNumber);
		
		src.withdraw(amount, password);
		target.deposit(amount);
		
	}

	public void printAccountList() {

		System.out.println("Account\tBalance\tName");
		
		for(BankAccount a: getAllAccounts()) {
			
			if(a!=null) //account may have been closed
				System.out.println(a); //use toString() method
		}
	}

	
	public void creditInterests() {

		System.out.println("Account\tBalance\tName");
		for(BankAccount a: getAllAccounts()) {
			
			if(a!=null)
				a.creditInterest(interestRate);
		}
	}

	
	public String getAccountInfo(int accountNumber, String pin) {
		// TODO Auto-generated method stub
		BankAccount account= getAccountById(accountNumber);
		account.authenticate(pin);
		return account.toString();
		
	}

	public BankAccount getAccount(int accountNumber, String password) {
		// TODO Auto-generated method stub
		BankAccount account=getAccountById(accountNumber);
		account.authenticate(password);
		return account;
	}
	
	
}
