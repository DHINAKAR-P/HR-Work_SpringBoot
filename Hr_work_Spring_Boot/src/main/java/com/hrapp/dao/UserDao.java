package com.hrapp.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hrapp.domain.core.Contact;
import com.hrapp.domain.core.InUser;
import com.hrapp.repository.UserContactRepository;
import com.hrapp.repository.UserRepository;

@Repository
public class UserDao {

	@Autowired
	 UserRepository userRepository;
	@Autowired
	UserContactRepository contctRepository;

	@Autowired
	UserContactRepository userContactRepository;

	@Transactional
	public int deleteUser(Long id) {

		return userRepository.deleteById(id);

	}

	public List<InUser> listOfUser() {
		return userRepository.findAll();
	}

	@Transactional
	public InUser updateUser(InUser user) {

		System.out.println("id" + user.getId());
		System.out.println("password" + user.getPassword());
		System.out.println("Username" + user.getUsername());
		// System.out.println("LeavTaken"+user.getLeaveTaken());

		return userRepository.saveAndFlush(user);
	}


	@Transactional
	public Contact updateUserContact(Contact u) {
		System.out.println("id in dao" + u.getId());

		return userContactRepository.saveAndFlush(u);// userContactRepository.updateUserContact(contact.getId(),contact.getAddress(),contact.getPhone(),contact.getPhotoUrl(),contact.getEmailAddress());

	}

	public InUser findById(InUser user) {
		return userRepository.findById(user.getId());
	}

	public InUser findUserById(Long id)
	{
		return userRepository.findById(id);
	}

	
	public InUser findByPassword(String password) {
	
		return userRepository.findByPassword(password);
	}

	public InUser findByUserName(String userName) { 
		
		return userRepository.findByUsername(userName);
	}
	public int userActivate(InUser user) {

		return userRepository.userActivate(user.getId(), user.getStatus());
	}
	
}
