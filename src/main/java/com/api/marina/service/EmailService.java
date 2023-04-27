package com.api.marina.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.api.marina.enums.StatusEmail;
import com.api.marina.model.Email;
import com.api.marina.repository.EmailRepository;

@Service
public class EmailService {

	@Autowired
	EmailRepository repository;
	
	@Autowired
	private JavaMailSender emailSender;

	@SuppressWarnings("finally")
	public Email sendEmail(Email email) {
		
		email.setSendDateEmail(LocalDateTime.now());
		try {//tenta enviar o email
			SimpleMailMessage message = new SimpleMailMessage();//cria uma instancia de simpleMailMesg
			
			message.setFrom(email.getEmailFrom());//seta as variaveis
			message.setTo(email.getEmailTo());
			message.setSubject(email.getSubject());
			message.setText(email.getText());
			
			emailSender.send(message);//salva a mensgem dentro de emailSender
			
			email.setStatus(StatusEmail.SENT);//se der certo , salva o email como enviado
		} catch(MailException e) {
			
			email.setStatus(StatusEmail.ERROR);//caso de errado, seta o status do email como erro
		} finally {
			return repository.save(email);//retorna ao usuario se deu certo ou se deu erro.
		}
	}
}
