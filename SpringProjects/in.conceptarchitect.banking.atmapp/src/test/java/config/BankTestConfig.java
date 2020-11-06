package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import in.conceptarchitect.banking.core.Bank;
import in.conceptarchitect.banking.core.BankAccount;
import in.conceptarchitect.banking.repository.AccountRepository;
import in.conceptarchitect.banking.repository.HashmapAccountRepository;
import in.conceptarchitect.reflection.AutoObjectCreator;
import in.conceptarchitect.reflection.ObjectCreator;

@Configuration
public class BankTestConfig {

	@Bean
	public AccountRepository accountRepository() {
		HashmapAccountRepository repository= new HashmapAccountRepository();
		repository.seed();
		return repository;
	}
	
	@Bean
	public ObjectCreator<BankAccount> accountCreator(){
		return new AutoObjectCreator<BankAccount>();
	}
	
	@Bean
	public Bank bank(AccountRepository repository, ObjectCreator<BankAccount> accountCreator) {
		Bank bank=new Bank("ICICI", 12, repository);
		bank.setAccountCreator(accountCreator);
		return bank;
	}
	
}
