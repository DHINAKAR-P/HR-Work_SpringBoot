package com.hrapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hrapp.domain.core.Contact;




public interface UserContactRepository extends JpaRepository<Contact, Long> {
	 

}
