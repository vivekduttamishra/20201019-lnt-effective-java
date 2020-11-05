package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import in.conceptarchitect.banking.atm.ATM;
import in.conceptarchitect.banking.core.Bank;
import in.conceptarchitect.banking.core.BankAccount;
import in.conceptarchitect.banking.reposiotory.jdbc.JdbcAccountRepository;
import in.conceptarchitect.banking.repository.AccountRepository;
import in.conceptarchitect.jdbc.JdbcManager;
import in.conceptarchitect.reflection.AutoObjectCreator;
import in.conceptarchitect.reflection.ObjectCreator;

@Configuration
public class AppConfig01 {

	
	@Bean
	public ObjectCreator<BankAccount> accountCreator(){
		return new AutoObjectCreator<BankAccount>();
	}
	
	
	@Bean
	public JdbcManager accountJdbcManager() {
		System.out.println("jdbcManager created...");
		JdbcManager manager=new JdbcManager();
		manager.setUrl("jdbc:mysql://localhost/bankingdb");
		manager.setUserName("root");
		manager.setPassword("@DM1n.");
		return manager;
		
	}
	
	@Bean 
	AccountRepository accountRepository() {
	
		return new JdbcAccountRepository(accountJdbcManager());
		
	}
	@Bean
	public Bank bank(AccountRepository repository, 
					 ObjectCreator<BankAccount> accountCreator) {
		Bank bank=new Bank("ICICI",12, repository);
		bank.setAccountCreator(accountCreator);
		return bank;
	}
	
	@Bean
	public ATM atm(Bank bank) {
		
		ATM atm=new ATM();
		atm.setBank(bank);
		return atm;
	}
	
	
	
	

}
