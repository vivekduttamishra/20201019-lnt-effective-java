package config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import in.conceptarchitect.banking.core.BankAccount;
import in.conceptarchitect.banking.reposiotory.jdbc.JdbcAccountRepository;
import in.conceptarchitect.banking.repository.AccountRepository;
import in.conceptarchitect.jdbc.JdbcManager;
import in.conceptarchitect.reflection.AutoObjectCreator;
import in.conceptarchitect.reflection.ObjectCreator;

@Configuration
@PropertySource("classpath:app.properties")
@ComponentScan(basePackages = "in.conceptarchitect")
public class AppConfig {

//	@Value("${DB_USER}")
//	String userName;
//	
//	@Value("${DB_PASSWORD}")
//	String password;
//	
//	@Value("${DB_URL}")
//	String url;
//	
//	@Bean
//	public JdbcManager accountJdbcManager() {
//		System.out.println("jdbcManager created...");
//		JdbcManager manager=new JdbcManager();
//		manager.setUrl(url);
//		manager.setUserName(userName);
//		manager.setPassword(password);
//		return manager;
//		
//	}

	
	
	@Bean
	public ObjectCreator<BankAccount> accountCreator(){
		return new AutoObjectCreator<BankAccount>();
	}
	
	@Autowired JdbcManager manager;
	
	@Bean 
	AccountRepository accountRepository() {
	
		return new JdbcAccountRepository(manager);
		
	}

	
	
	
	

}
