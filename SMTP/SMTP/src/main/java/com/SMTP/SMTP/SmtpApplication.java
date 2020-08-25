package com.SMTP.SMTP;

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

	public static void main(String[] args) {
		SpringApplication.run(SmtpApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Sending email...");

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
//	void SendEmailWithAttachement() throws MessagingException, IOException {
//		MimeMessage SimpleMailMesaage= (MimeMessage) JavaMailSender.createMimeMessage();
//		MimeMessageHelper helper=new MimeMessageHelper(SimpleMailMesaage,true);
//		helper.setTo(("saisirisha0304@gmail.com"));
//		helper.setSubject("Testing from springboot");
//		helper.setText("<h1>check attachment for image!</h1>",true);
//		helper.addAttachment("my_photo.png",new ClassPathResource("android.png"));
//	}
}
