package com.api.marina.dto;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data //ja injeta getter, setter e construtor
public class EmailDto {
	
	//fazer validação com validation
	@NotBlank//campos obrigatorios
	private String ownerRef;//referencia do proprietario que esta mandando a mensagem
	
	@Email//verificar se o email é válido
	private String emailFrom;//de quem esta mandando
	
	@Email
	private String emailTo;//para quem esta sendo enviado
	
	@NotBlank
	private String subject;//titulo do email
	
	@NotBlank
	private String text;//campo de texto do email

}
