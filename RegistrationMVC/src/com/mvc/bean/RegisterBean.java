package com.mvc.bean;

import java.util.Date;

public class RegisterBean {

	// instance variables
	private Integer id;
	private String fullName;
	private String email;
	private String userName;
	private String password;
	private String active;
	private String roleId;
	private String gender;
	private Date date;
	
	
	//Default constructor
	public RegisterBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	//parameterised constructor
	public RegisterBean(Integer id, String fullName, String email,
			String userName, String password, String active, String roleId,String gender,
			Date date ) {
		super();
		this.id = id;
		this.fullName = fullName;
		this.email = email;
		this.userName = userName;
		this.password = password;
		this.active = active;
		this.roleId = roleId;
		this.gender = gender;
		this.date = date;		
	}

	//parameterised constructor
	public RegisterBean(String fullName, String email, String userName,
			String password, String active, String roleId, String gender,
			Date date) {
		super();
		this.fullName = fullName;
		this.email = email;
		this.userName = userName;
		this.password = password;
		this.active = active;
		this.roleId = roleId;
		this.gender = gender;
		this.date = date;
	}

	//getters and setters
	public Integer getid() {
		return id;
	}

	public void setid(Integer id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	//toString method
	@Override
	public String toString() {
		return "RegisterBean [id=" + id + ", fullName=" + fullName
				+ ", email=" + email + ", userName=" + userName + ", password="
				+ password + ", active=" + active + ", roleId=" + roleId
				+ ", gender=" + gender + ", date=" + date + "]";
	}

	

	
	
	
	
	
}