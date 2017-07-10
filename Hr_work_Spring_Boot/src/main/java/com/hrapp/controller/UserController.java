package com.hrapp.controller;

import java.util.List;


import org.apache.commons.httpclient.HttpStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hrapp.domain.core.InUser;
import com.hrapp.domain.core.UserStatus;
import com.hrapp.response.ResponseWrapper;
import com.hrapp.serviceimpl.LoginService;
import com.hrapp.serviceimpl.UserService;
import com.hrapp.serviceimpl.hrworkObjectConverter;

@RestController
@RequestMapping(value = "/user")
public class UserController {
	private Logger LOG = LoggerFactory.getLogger(UserController.class);

	@Autowired
	LoginService loginservice;

	@Autowired
	UserService userService;

	List<InUser> listArray;
	@Autowired
	private hrworkObjectConverter objectconverter;

	@RequestMapping(value = "/createuser", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public ResponseWrapper createUser(@RequestBody InUser user) {
		ResponseWrapper response = new ResponseWrapper();
		LOG.debug("To create user");

		try {

	          user = loginservice.SaveUser(user);

			if (user == null) {
				response.setResponseCode(org.apache.commons.httpclient.HttpStatus.SC_NOT_FOUND);
				response.setResponseError("User not created successfully,plz try once again!");
				return response;
			}

			response.setResponseCode(HttpStatus.SC_OK);
			response.setResult(user);
			response.setResponseSuccess("You have create a user successfully!");

			return response;

		} catch (Exception e) {
			LOG.error("Error while creating user:", e);
			response.setResponseCode(org.apache.commons.httpclient.HttpStatus.SC_INTERNAL_SERVER_ERROR);
			response.setResponseError("Internal service error occured while Creating user, please try again!");
			return response;
		}

	}

	 

	@RequestMapping(value = "/deleteuser", method = RequestMethod.GET)
	public ResponseWrapper deleteuser(@RequestParam("id") Long id) {
		ResponseWrapper response = new ResponseWrapper();
		LOG.debug("To delete User");

		try {

			int result = userService.deleteUser(id);

			if (result != 0) {
				response.setResponseCode(HttpStatus.SC_OK);
				response.setResponseSuccess("You have DELETE a User successfully!");
				return response;
			}
			response.setResponseCode(org.apache.commons.httpclient.HttpStatus.SC_NOT_FOUND);
			response.setResponseError("No User Found in Database!");

			return response;

		}

		catch (Exception e) {
			LOG.error("Error while Delete User in Db:", e);
			response.setResponseCode(org.apache.commons.httpclient.HttpStatus.SC_INTERNAL_SERVER_ERROR);
			response.setResponseError("Internal service error occured while Deleteing User, please try again!");
			return response;
		}

	}

	
	 
	ObjectMapper obj = new ObjectMapper();

	@RequestMapping(value = "/listOfUser", method = RequestMethod.GET)
	public ResponseWrapper listUser() {

		List<InUser> userlist = userService.listOfUser();
		System.out.println("List of user are" + userlist);

		ResponseWrapper response = new ResponseWrapper();
		LOG.debug("To List All User");
		try {
			if (userlist == null) {
				response.setResponseCode(org.apache.commons.httpclient.HttpStatus.SC_NOT_FOUND);
				response.setResponseError("Users are not exist,plz try once again!");
				return response;
			}
			response.setResponseCode(HttpStatus.SC_OK);
			response.setResult(userlist);
			response.setResponseSuccess("You have Listed the User values!");

			return response;

		} catch (Exception e) {
			LOG.error("Error while Listing users:", e);
			response.setResponseCode(org.apache.commons.httpclient.HttpStatus.SC_INTERNAL_SERVER_ERROR);
			response.setResponseError("Internal service error occured while Listing user, please try again!");
			return response;
		}

	}

	
	 
	@RequestMapping(value = "/updateUser", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public ResponseWrapper updateUser(@RequestBody InUser user) {
		ResponseWrapper response = new ResponseWrapper();
		LOG.debug("To Update user");

		try {

			InUser result = userService.updateUser(user);
			// Contact result = userService.updateUserContact(user);

			if (result == null) {
				response.setResponseCode(org.apache.commons.httpclient.HttpStatus.SC_NOT_FOUND);
				response.setResponseError("User not updated successfully,plz try once again!");
				return response;
			}

			response.setResponseCode(HttpStatus.SC_OK);
			response.setResult(result);
			response.setResponseSuccess("You have Update a user's Details  successfully!");

			return response;

		} catch (Exception e) {
			LOG.error("Error while creating user:", e);
			response.setResponseCode(org.apache.commons.httpclient.HttpStatus.SC_INTERNAL_SERVER_ERROR);
			response.setResponseError("Internal service error occured while Updating user Details, please try again!");
			return response;
		}
	}

	
	 

	 

	
	 
	@RequestMapping(value = "/findUserById", method = RequestMethod.GET)
	public ResponseWrapper findUser(@RequestParam("id") Long id) {
		ResponseWrapper response = new ResponseWrapper();
		LOG.debug("To delete User");

		try {

			InUser result = userService.findById(id);

			if (result != null) {
				response.setResponseCode(HttpStatus.SC_OK);
				response.setResponseSuccess("a User find  successfully!");
				response.setResult(result);
				return response;
			}
			response.setResponseCode(org.apache.commons.httpclient.HttpStatus.SC_NOT_FOUND);
			response.setResponseError("No User Found in Database!");

			return response;

		}

		catch (Exception e) {
			LOG.error("Error while Delete User in Db:", e);
			response.setResponseCode(org.apache.commons.httpclient.HttpStatus.SC_INTERNAL_SERVER_ERROR);
			response.setResponseError("Internal service error occured while Deleteing User, please try again!");
			return response;
		}
	}

	
	 
	@RequestMapping(value = "/findBypassword", method = RequestMethod.GET)
	public ResponseWrapper findUserBypassword(
			@RequestParam("password") String password) {
		ResponseWrapper response = new ResponseWrapper();
		LOG.debug("To find User by emailadress");

		try {

			InUser result = userService.findByPassword(password);

			if (result != null) {
				response.setResponseCode(HttpStatus.SC_OK);
				response.setResponseSuccess("a User find  successfully!");
				response.setResult(result);
				return response;
			}
			response.setResponseCode(org.apache.commons.httpclient.HttpStatus.SC_NOT_FOUND);
			response.setResponseError("No User Found in Database!");

			return response;

		}

		catch (Exception e) {
			LOG.error("error while finding user in Db:", e);
			response.setResponseCode(org.apache.commons.httpclient.HttpStatus.SC_INTERNAL_SERVER_ERROR);
			response.setResponseError("Internal service error occured while Deleteing User, please try again!");
			return response;
		}

	}
	
	@RequestMapping(value = "/userStatus", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public Object userActivate(@RequestBody InUser user) {

		ResponseWrapper response = new ResponseWrapper();

		LOG.debug("To Change the User Status");
		try {
			if (user==null) {
				response.setResponseCode(org.apache.commons.httpclient.HttpStatus.SC_NOT_FOUND);
				response.setResponseError(" You has not change the user Status ,plz try once again!");
				return response;
			}

			else if (user.getStatus().ordinal() == 1) {
				System.out.println("user to deactivted");
				System.out.println(user.getStatus());
				user.setStatus(UserStatus.DEACTIVATED);
				System.out.println("User Deactivated" + user.getStatus());
				userService.userActivate(user);
				response.setResponseCode(HttpStatus.SC_OK);
				response.setResponseSuccess("User Deactivated!");
				response.setResult(user);
				return response;
			}
			System.out.println("outside status check user going to activted");
			System.out.println(user.getStatus());
			user.setStatus(UserStatus.ACTIVATED);
			System.out.println("User Activated" + user.getStatus());
			userService.userActivate(user);
			response.setResponseCode(HttpStatus.SC_OK);
			response.setResponseSuccess("User activated!");
			response.setResult(user);
			return response;

		} catch (Exception e) {
			LOG.error("Error while get Leave Details:", e);
			response.setResponseCode(org.apache.commons.httpclient.HttpStatus.SC_INTERNAL_SERVER_ERROR);
			response.setResponseError("Internal service error occured While User Status Changing , please try again!");
			return response;
		}
	}

	

}

