package com.api.marina.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import com.api.marina.enums.StatusEmail;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import lombok.Data;

@Data
@Entity(name = "tb_email")
public class Email implements Serializable{/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long Id;
	private String ownerRef;//referencia do proprietario que esta mandando a mensagem
	private String emailFrom;//de quem esta mandando
	private String emailTo;//para quem esta sendo enviado
	private String subject;//titulo do email
	
	@Column(columnDefinition = "TEXT")//insere mais caracteres se for preciso, não limita o campo
	private String text;//campo de texto do email
	
	private LocalDateTime sendDateEmail;//data de envio do email
	private StatusEmail status;//se o email foi enviado

}
