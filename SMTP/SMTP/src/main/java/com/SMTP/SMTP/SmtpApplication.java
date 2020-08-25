package com.SMTP.SMTP;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.IOException;

@SpringBootApplication
public class SmtpApplication implements CommandLineRunner {

	@Autowired
	private JavaMailSender javaMailSender;

	private static final Logger logger = LoggerFactory.getLogger(SmtpApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SmtpApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("Sending email...");

		sendEmail();
	}

	private void sendEmail() {
		SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
		simpleMailMessage.setFrom("testforspringboot@gmail.com");
		simpleMailMessage.setTo("sivasaianusha9@gmail.com");
		simpleMailMessage.setSubject("Spring Boot tests email");
		simpleMailMessage.setText("Spring Boot tests email.. Hello World");

		javaMailSender.send(simpleMailMessage);
	}

}
