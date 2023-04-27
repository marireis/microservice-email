package com.api.marina.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.marina.model.Email;

public interface EmailRepository extends JpaRepository<Email, Long>{

}
