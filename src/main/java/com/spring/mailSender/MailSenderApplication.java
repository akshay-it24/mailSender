package com.spring.mailSender;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication(exclude = HibernateJpaAutoConfiguration.class)
public class MailSenderApplication extends SpringBootServletInitializer {

	
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(MailSenderApplication.class);
	}
	public static void main(String[] args) {
		SpringApplication.run(MailSenderApplication.class, args);
	}
}
