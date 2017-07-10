package com.hrapp.serviceimpl;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import com.hrapp.domain.core.InUser;


public interface LoginService  {

	public InUser SaveUser(InUser user);

	public InUser doLogin(InUser user);

	public int resetPassword(String oldpassword, String password, Long id);

	public InUser findByUserName(String userName);

	public InUser datastore( MultipartFile file,InUser user) throws IOException; 
	public byte[] download(); 

	 

}