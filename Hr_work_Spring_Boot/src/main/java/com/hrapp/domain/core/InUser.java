package com.hrapp.domain.core;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "InUser")
@JsonIgnoreProperties(ignoreUnknown = true)
public class InUser  {

	public InUser() {
		// TODO Auto-generated constructor stub
	}

	@Id
	@GeneratedValue
	private long id;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	@Column
	private UserStatus status;
	@Column
	private String address;
	@Column
	private String age;
	@Column
	private String phone_no;

	public String getPhone_no() {
		return phone_no;
	}

	public void setPhone_no(String phone_no) {
		this.phone_no = phone_no;
	}

	@Column
	private String username;
	@Column
	private String password;
	@Column
	private String languagepreference;
	@Column
	private String primaryemail;
	@Column
	private String phonenumber;

	@ManyToMany(fetch = FetchType.EAGER, cascade = { CascadeType.ALL })
	private Set<InAuthority> roles = new HashSet<InAuthority>();

	@Column
	private int newuser; // typically used for registration

	public Set<InAuthority> getRoles() {
		return roles;
	}

	public void setRoles(Set<InAuthority> roles) {
		this.roles = roles;
	}
	/*
	 * public void setRoles(List<InAuthority> list) { // TODO Auto-generated
	 * method stub
	 * 
	 * }
	 */

	public String getUsername() {
		return username;
	}

	public UserStatus getStatus() {
		return status;
	}

	public void setStatus(UserStatus status) {
		this.status = status;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getLanguagepreference() {
		return languagepreference;
	}

	public void setLanguagepreference(String languagepreference) {
		this.languagepreference = languagepreference;
	}

	public String getPrimaryemail() {
		return primaryemail;
	}

	public void setPrimaryemail(String primaryemail) {
		this.primaryemail = primaryemail;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
 
	public int getNewuser() {
		return newuser;
	}

	public void setNewuser(int newuser) {
		this.newuser = newuser;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "InUser [id=" + id + ", address=" + address + ", age=" + age + ", username=" + username + ", password="
				+ password + ", languagepreference=" + languagepreference + ", primaryemail=" + primaryemail
				+ ", phonenumber=" + phonenumber + ", roles=" + roles + ", newuser=" + newuser + "]";
	}

}