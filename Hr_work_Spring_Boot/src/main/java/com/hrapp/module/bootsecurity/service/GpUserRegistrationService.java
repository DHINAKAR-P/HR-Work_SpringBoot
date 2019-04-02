package com.hrapp.module.bootsecurity.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrapp.domain.core.InUser;
import com.hrapp.module.bootsecurity.dao.GpBootSecurityUserDao;


 
@Service("GpUserRegistrationService")
public class GpUserRegistrationService extends InBaseService{

	@Autowired
	private GpBootSecurityUserDao user_Dao;

	/**
	 * Registers a new user to the system - the method will enforce any required
	 * fields on the User class
	 *
	 * @param newuser
	 *            {@link com.npb.gp.domain.core.GpUser}
	 * @return com.npb.gp.domain.core.GpUser - with ID populated
	 * @throws Exception
	 *
	 *
	 */

	public InUser registerUser(InUser newuser) throws Exception {
		try {
			System.out
					.println("In  GpUserRegistrationService - registerUser()");

		} catch (Exception e) {
			logger.error("error occured in GpUserRegistrationService"
					+ " registerUser method()");
			logger.error("the user id is: " + newuser.getId()
					+ " the error is:");

			e.printStackTrace();
		/*	Locale lc = new Locale(newuser.getLanguagepreference());
			throw new Exception(ctx.getMessage(
					"GpUserRegistrationService.error.unknown", null, lc));*/
		}

		return null;

	}

	/**
	 * Registers a new user to the system - the method only requires that a user
	 * supply an email and password
	 *
	 * @param newuser
	 *            - type: com.npb.gp.domain.core.GpUser
	 * @return com.npb.gp.domain.core.GpUser - with ID populated
	 * @throws Exception
	 */
	public InUser lightRegisterUser(InUser newuser, GpBootSecurityUserDao obj) throws Exception {
		InUser newgpuser=null;

		try {
			System.out
					.println("In  GpUserRegistrationService - lightRegisterUser()");

			Date saltdate = new Date();
			String thesalt = new Long(saltdate.getTime()).toString();// save
																		// this
																		// to
																		// the
																		// DB

			System.out
					.println("In  GpUserRegistrationService - lightRegisterUser()"
							+ " thesalt is: " + thesalt);

			//ShaPasswordEncoder enc = new ShaPasswordEncoder(256); // 256 s/b
																	// configurable
			/*String encrypted = enc.encodePassword(newuser.getPassword(),
					thesalt); // save this to DB

			System.out
					.println("In  GpUserRegistrationService - lightRegisterUser()"

							+ " the encrypted password is: " + encrypted);*/

			//newuser.setPassword(newuser.getPassword());
			if(user_Dao == null){
				user_Dao = obj;
			}

			this.user_Dao.insert(newuser);

		} catch (Exception e) {
			logger.error("error occured in GpUserRegistrationService"
					+ " lightRegisterUser method()");
			logger.error("the user id is: " + newuser.getId()
					+ " the error is:");
			e.printStackTrace();
			/*Locale lc = new Locale(newuser.getLanguagepreference());
			throw new Exception(ctx.getMessage(
					"GpUserRegistrationService.error.unknown", null, lc));*/
		}

		// save in DB
		return newgpuser;

	}

}
