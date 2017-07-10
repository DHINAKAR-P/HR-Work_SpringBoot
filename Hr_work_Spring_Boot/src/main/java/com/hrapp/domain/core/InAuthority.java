package com.hrapp.domain.core;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.hrapp.module.bootsecurity.service.InBaseAuthority;


@Entity
@Table(name="InAuthority")
public class InAuthority extends InBaseAuthority {

	@Transient
	private final Log logger = LogFactory.getLog(getClass());

	@Id
	@GeneratedValue
	private long id;
	@Column
	private String authority;


	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getAuthority() {
		return authority;
	}
	public void setAuthority(String authority) {
		this.authority = authority;
	}


	public boolean isPermitted(String authstring) {
		logger.debug("Authority- In isPermitted " + " authstring is:"
														+ authstring);
		logger.debug("Authority- In isPermitted " + " this.authority is:"
				+ this.authority);

		int roleNeeded = super.getRoleHierArchyPosition(authstring);

		if(roleNeeded <= super.getRoleHierArchyPosition(this.authority)) {
			logger.debug("Authority- In isPermitted " + "return code is: true");
			return true;
		}
		logger.debug("Authority- In isPermitted " + "return code is: false");
		return false;
	}


}