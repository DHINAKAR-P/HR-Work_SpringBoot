package com.hrapp.module.bootsecurity.service;

import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hrapp.domain.core.InAuthority;
import com.hrapp.domain.core.InUser;
import com.hrapp.module.bootsecurity.iservices.IGpUserService;


@Service
@Transactional
public class GpBootSecurityUserService implements  IGpUserService {

	@Autowired
	private com.hrapp.module.bootsecurity.dao.GpBootSecurityUserDao gpuser_Dao;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("loadUserByUsername............> "+username);

		InUser user = gpuser_Dao.findUser(username);
		if (user == null) {
			throw new UsernameNotFoundException("No User found");
		}
		System.out.println("CHECKED USER NAME............> "+user.getUsername());
		return (UserDetails) user;

	}

	public InUser authenticateSocialUser(InUser gpuser, HttpServletRequest request) throws Exception{

		Set<InAuthority> authorities = new HashSet<InAuthority>();
		InAuthority authority = new InAuthority();
		authority.setAuthority("ROLE_USER");
		authorities.add(authority);
		gpuser.setRoles(authorities);

		Authentication authentication = new UsernamePasswordAuthenticationToken(
				gpuser.getUsername(), gpuser.getPassword(),
				AuthorityUtils.createAuthorityList(gpuser.getAuthorities()
						.toString()));

		SecurityContext securityContext = SecurityContextHolder
				.getContext();
		securityContext.setAuthentication(authentication);

		// Create a new session and add the security context.
		HttpSession session = request.getSession(true);
		session.setAttribute("SPRING_SECURITY_CONTEXT", securityContext);

		InUser user = gpuser_Dao.findUser(gpuser.getUsername());
		if (user == null) {
			//create new user
				user = new InUser();
				user.setUsername(gpuser.getUsername());
				user.setPassword("password");
				user = gpuser_Dao.insert(user);

		}else{
			user = gpuser;
		}

		return user;

	}
}
