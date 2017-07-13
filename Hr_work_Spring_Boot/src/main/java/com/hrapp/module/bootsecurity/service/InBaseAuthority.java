package com.hrapp.module.bootsecurity.service;

public class InBaseAuthority {

	public static int ROLE_ADMIN = 100;
	public static int ROLE_HRMANAGER = 90;
	public static int ROLE_FLOORMANAGER = 80;
	public static int ROLE_TEAMLEAD = 70;
	public static int ROLE_SME = 60; // (SME --> Subject Matter Expert)
	public static int ROLE_EMPLOYEE = 50;

	public int getRoleHierArchyPosition(String role_string) {

		if (role_string.equals("ROLE_ADMIN")) {
			return InBaseAuthority.ROLE_ADMIN;
		} else if (role_string.equals("ROLE_HRMANAGER")) {
			return InBaseAuthority.ROLE_HRMANAGER;
		} else if (role_string.equals("ROLE_FLOORMANAGER")) {
			return InBaseAuthority.ROLE_FLOORMANAGER;
		} else if (role_string.equals("ROLE_TEAMLEAD")) {
			return InBaseAuthority.ROLE_TEAMLEAD;
		} else if (role_string.equals("ROLE_SME")) {
			return InBaseAuthority.ROLE_SME;
		} else if (role_string.equals("ROLE_EMPLOYEE")) {
			return InBaseAuthority.ROLE_EMPLOYEE;
		} else {
			return 0;
		}
	}

}