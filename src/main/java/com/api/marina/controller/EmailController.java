package com.api.marina.controller;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.marina.dto.EmailDto;
import com.api.marina.model.Email;
import com.api.marina.service.EmailService;

@RestController
public class EmailController {

	@Autowired
	EmailService service;
	
	@PostMapping("/sending-email")
	public ResponseEntity<Email> sendingEmail(@RequestBody @Valid EmailDto emailDto){
		
		Email email = new Email();//cria uma instancia de email
		BeanUtils.copyProperties(emailDto, email);//metodo que converte dto para model
		service.sendEmail(email);
		return new ResponseEntity<>(email, HttpStatus.CREATED);//retorna o email salvo e o status http criado
	}
	
	
}
