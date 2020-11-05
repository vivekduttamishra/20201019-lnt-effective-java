package in.conceptarchitect.banking.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import in.conceptarchitect.banking.exceptions.InsufficientBalanceException;
import in.conceptarchitect.banking.repository.AccountRepository;
import in.conceptarchitect.reflection.ObjectCreator;


@Service
public class Bank {
	
	int accountCount=0;   	
	String name;
	double interestRate;
	
	@Autowired
	ObjectCreator<BankAccount> accountCreator;
	//@Autowired the setter or constructor instead of field
	AccountRepository accounts;
	
	@Autowired
	@Qualifier("accountRepository")
	public void setAccounts(AccountRepository accounts) {
		this.accounts = accounts;
	}	
	
	
	public AccountRepository getAccounts() {
		return accounts;
	}


	
	
	public void setName(String name) {
		this.name = name;
	}

	
	public void setAccountCreator(ObjectCreator<BankAccount> accountCreator) {
		System.out.println("bank set to use accountCreator:"+accountCreator.getClass().getSimpleName());
		this.accountCreator = accountCreator;  //can be replaced later
	}
	
	public ObjectCreator<BankAccount> getAccountCreator() {
		return accountCreator;
	}

	
	
	public Bank() {
		System.out.println("Bank object created...");
	}
	
	public Bank(String name, 
				double interestRate, 
				AccountRepository accounts) {
	
		this.interestRate=interestRate;
		this.name=name;
		this.accounts=accounts;
		System.out.printf("Bank %s created\n", name);
		 
	}
	
	

	public int openAccount(String accountType,String name, String password,  double amount) {
		
//		BankAccount account=null;	
//		switch(accountType.toLowerCase()) {
//		
//			default: case "savings": account=new SavingsAccount(name,password,amount);break;
//			case "current": account=new CurrentAccount(name,password,amount);break;
//			case "overdraft":account=new OverDraftAccount(name,password,amount); break;
//		}
//		
//		
//		
//		//Bank should set the account Number which is accessible due to package scope
		
		if(!accountType.contains("."))
			accountType="in.conceptarchitect.banking.core."+accountType;

		BankAccount account= (BankAccount) accountCreator.create(accountType, name, password, amount);
		account.accountNumber=++accountCount;
		
		return accounts.addAccount(account);
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
		BankAccount account = accounts.getAccountById(accountNumber);
		account.deposit(amount);
		accounts.save(account);
	}
	
	public void changePassword(int accountNumber, String currentPassword, String newPassword) {
		BankAccount account=accounts.getAccountById(accountNumber);
		account.changePassword(currentPassword, newPassword);
		accounts.save(account);
	}
	
	
	

	public void closeAccount(int accountNumber, String password) {
		BankAccount account = accounts.getAccountById(accountNumber);
		
		account.authenticate(password);
		
		if(account.getBalance()<0)
			throw new InsufficientBalanceException(accountNumber, -account.getBalance()," You need to clear the overdue to close your account");
		
		
		accounts.removeAccount(accountNumber);

	}


	public void withdraw(int accountNumber, double amount, String password) {
		BankAccount account = accounts.getAccountById(accountNumber);
		account.withdraw(amount, password); //may return success or falure
		
		accounts.save(account);
	}
	
	
	public void transfer(int sourceAccountNumber,  double amount, String password,int targetAccountNumber) {
		
		BankAccount target=accounts.getAccountById(targetAccountNumber);
		BankAccount src = accounts.getAccountById(sourceAccountNumber);
		
		src.withdraw(amount, password);
		target.deposit(amount);
		
		accounts.save(src);
		accounts.save(target);
		
	}

	public void printAccountList() {

		System.out.println("Account\tBalance\tName");
		
		for(BankAccount a: accounts.getAllAccounts()) {
			
			if(a!=null) //account may have been closed
				System.out.println(a); //use toString() method
		}
	}

	
	public void creditInterests() {

		
		for(BankAccount a: accounts.getAllAccounts()) {
			
			if(a!=null) {
				a.creditInterest(interestRate);
				accounts.save(a);
			}
		}
				
	}

	
	public String getAccountInfo(int accountNumber, String pin) {
		// TODO Auto-generated method stub
		BankAccount account= accounts.getAccountById(accountNumber);
		account.authenticate(pin);
		return account.toString();
		
	}

	public BankAccount getAccount(int accountNumber, String password) {
		// TODO Auto-generated method stub
		BankAccount account=accounts.getAccountById(accountNumber);
		account.authenticate(password);
		return account;
	}
	
	
}
