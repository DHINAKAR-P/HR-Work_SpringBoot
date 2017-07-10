package com.hrapp.serviceimpl;

import java.util.List;

import com.hrapp.domain.core.Contact;
import com.hrapp.domain.core.InUser;
public interface UserService {
	public int deleteUser(Long id);
	public List<InUser> listOfUser();
	public InUser updateUser(InUser user);
	public int userActivate(InUser user);
	public InUser findById( Long id);
	public InUser findByPassword(String emailAddress);
	public Contact updateUserContact(InUser user);
}
