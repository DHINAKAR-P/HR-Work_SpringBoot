package com.hrapp.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hrapp.dao.UserDao;
import com.hrapp.domain.core.Contact;
import com.hrapp.domain.core.InUser;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userDao;

	@Transactional
	public int deleteUser(Long id) {

		return userDao.deleteUser(id);
	}

	public List<InUser> listOfUser() {

		return userDao.listOfUser();
	}

	
	 
	
	
	 

	

	public InUser findById(Long id) {

		return userDao.findUserById(id);
	}

	public InUser findByPassword(String password) {

		return userDao.findByPassword(password);
	}

	public InUser findByUserName(String userName) {

		return userDao.findByUserName(userName);
	}

	@Override
	public InUser updateUser(InUser user) {
		// TODO Auto-generated method stub
		return userDao.updateUser(user);
	}

	@Override
	public int userActivate(InUser user) {
		return userDao.userActivate(user);
	}

	@Override
	public Contact updateUserContact(InUser user) {
		// TODO Auto-generated method stub
		return null;
	}
}
