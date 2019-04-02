package com.hrapp.module.bootsecurity.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hrapp.domain.core.InUser;
import com.hrapp.module.bootsecurity.service.GpBootSecurityUserService;

/*import geppetto.GreenSnake.app.domain.core.GpUser;*/

@Controller("UserController")
@RequestMapping("/user")
public class GpBootSecurityUserController {

	@Autowired
	GpBootSecurityUserService user_service;


	@RequestMapping(value="/createsocialuser",method = RequestMethod.POST)
	public @ResponseBody
	InUser create(HttpServletRequest request,
			@RequestBody InUser gpuser) {
		try {
//			user_service.authenticateSocialUser(gpuser,request);
			return gpuser;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
