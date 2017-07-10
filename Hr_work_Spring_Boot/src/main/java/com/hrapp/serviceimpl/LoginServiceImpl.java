package com.hrapp.serviceimpl;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.hrapp.dao.LoginDao;
import com.hrapp.domain.core.InUser;


@Service
public class LoginServiceImpl implements LoginService{
	@Autowired
	 LoginDao loginDao;

	public InUser SaveUser(InUser user) {


		return loginDao.SaveUser(user);

	}

	public InUser doLogin(InUser user) {

		System.out.println("i am in login service and my userName---- "+user.getUsername() );
		System.out.println("i am in login service and my password---- "+user.getPassword() );
		
		
		return loginDao.doLogin(user);
	}

	public int resetPassword(String oldpassword, String password, Long id) {
		
		return loginDao.resetPassword(oldpassword,password,id);
	}

	public InUser findByUserName(String userName) {
		
		return loginDao.findByUserName(userName);
	}

	 @Transactional
	 public InUser datastore(MultipartFile file,InUser userString) throws IOException {
		
		return loginDao.datastore(file,userString);
	 }

	@Override
	public byte[] download() {
		// TODO Auto-generated method stub
		return null;
	}

	 
}
