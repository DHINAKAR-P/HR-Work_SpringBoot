package com.hrapp.module.bootsecurity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hrapp.domain.core.InUser;


@Service
@Transactional
public class GpBootSecurityUserService  {

	@Autowired
	private com.hrapp.module.bootsecurity.dao.GpBootSecurityUserDao gpuser_Dao;

	public InUser loadUserByUsername(String username) throws Exception {
		System.out.println("loadUserByUsername............> "+username);

		InUser user = gpuser_Dao.findUser(username);
		if (user == null) {
			throw new Exception("No User found");
		}
		System.out.println("CHECKED USER NAME............> "+user.getUsername());
		return (InUser) user;

	}

	/*public InUser authenticateSocialUser(InUser gpuser, HttpServletRequest request) throws Exception{

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

	}*/
}
