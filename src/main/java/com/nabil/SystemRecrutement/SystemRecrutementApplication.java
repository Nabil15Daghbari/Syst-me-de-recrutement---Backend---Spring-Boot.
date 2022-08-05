package com.nabil.SystemRecrutement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
// on va dir a spring qui on a des classe auditier danc il doit activier l'auditing 
@EnableJpaAuditing
public class SystemRecrutementApplication {

	public static void main(String[] args) {
		SpringApplication.run(SystemRecrutementApplication.class, args);
	}

}
