package com.api.marina.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.marina.repository.EmailRepository;

@Service
public class EmailService {

	@Autowired
	EmailRepository repository;
}
