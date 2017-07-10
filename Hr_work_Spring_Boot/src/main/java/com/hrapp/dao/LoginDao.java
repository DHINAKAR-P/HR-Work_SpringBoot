package com.hrapp.dao;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.hrapp.domain.core.InUser;
import com.hrapp.repository.UserRepository;


@Repository
public class LoginDao {

	@Autowired
	 UserRepository userRepository;

	@Transactional
	public InUser SaveUser(InUser user) {

		return userRepository.save(user);

	}

	public InUser doLogin(InUser user) {

		System.out.println("in dao" + user.getUsername());
		System.out.println("in dao password" + user.getPassword().toUpperCase());
		return userRepository.doLogin(user.getUsername(), user.getPassword());
	}

	public int resetPassword(String oldpassword, String password, Long id) {

		return userRepository.resetPassword(oldpassword, password, id);
	}

	public InUser findByUserName(String userName) {

		return userRepository.findByUsername(userName);
	}

	public InUser datastore(MultipartFile file, InUser userString) throws IOException {

		return userRepository.save(userString);

	}

	

}
