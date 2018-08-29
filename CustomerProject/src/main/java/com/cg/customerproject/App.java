package com.cg.customerproject;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

import com.cg.customerproject.account.Account;
import com.cg.customerproject.accountRepo.AccountRepository;
import com.cg.customerproject.repository.CustomerRepository;

/**
 * Hello world!
 *
 */
//@EnableGlobalMethodSecurity
@SpringBootApplication
public class App {
	Logger logger = (Logger) LoggerFactory.getLogger(App.class);
	public static void main(String[] args) {
		// System.out.println( "Hello World!" );
		SpringApplication.run(App.class, args);
	}

	@Bean
    public CommandLineRunner initialLoadDataJPA(CustomerRepository repository) {
    	
    	logger.debug("It is a  debug logging");
    	logger.info("It is a  info logging");
    	logger.warn("It is a  warn logging");
    	logger.error("It is a  error logging");
    	//logger.fatal("It is a  fatal logging");
		return (args) -> {
			repository.save(new Customer(120, "Nyaah", 9844540, "nyaah@gmail.com", "22/5/1990"));
			repository.save(new Customer(113, "Myra", 986755, "myra@gmail.com", "2/8/1990"));
			repository.save(new Customer(114, "Riya", 9877765, "riya@gmail.com", "22/10/1990"));
			repository.save(new Customer(115, "Alia", 980065, "alia@gmail.com", "12/7/1990"));
			repository.save(new Customer(116, "Amyra", 9766434, "amyra@gmail.com", "6/5/1990"));
			repository.save(new Customer(117, "Ryan", 9843433, "ryan@gmail.com", "18/5/1990"));
			repository.save(new Customer(118, "John", 9807655, "john@gmail.com", "30/5/1990"));
			repository.save(new Customer(119, "Charlie", 9987665, "charlie@gmail.com", "1/1/1990"));
			System.out.println("Database initially loaded");
		};
	}

	@Bean
	public CommandLineRunner initialLoadDataMongo(AccountRepository accRepository) {

		/*
		 * logger.debug("It is a  debug logging"); logger.info("It is a  info logging");
		 * logger.warn("It is a  warn logging"); logger.error("It is a  error logging");
		 * logger.fatal("It is a  fatal logging");
		 */
		return (args) -> {
			accRepository.save(new Account(120, "Nyaah", "Savings Account"));
			accRepository.save(new Account(113, "Myra", "Current Account"));
			accRepository.save(new Account(114, "Riya", "Savings Account"));
			accRepository.save(new Account(115, "Alia", "Current Account"));
			accRepository.save(new Account(116, "Amyra", "Current Account"));
			accRepository.save(new Account(117, "Ryan", "Savings Account"));
			accRepository.save(new Account(118, "John", "Current Account"));
			accRepository.save(new Account(119, "Charlie", "Savings Account"));
			System.out.println("Database initially loaded(MongoDB)");
		};
	}
}
