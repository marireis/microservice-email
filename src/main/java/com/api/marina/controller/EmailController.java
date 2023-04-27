package com.api.marina.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.api.marina.service.EmailService;

@RestController
public class EmailController {

	@Autowired
	EmailService service;
}
