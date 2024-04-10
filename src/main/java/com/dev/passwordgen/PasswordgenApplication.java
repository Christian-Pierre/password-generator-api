package com.dev.passwordgen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class PasswordgenApplication {

	public static void main(String[] args) {
		SpringApplication.run(PasswordgenApplication.class, args);
	}

}
