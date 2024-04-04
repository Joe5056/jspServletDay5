package com.model;

public class UserDTO {
	String username;
	String password;
	String fullname;
	String designation;
	int salary;
	
	//Use Source->superclass, fields and getter & setter and then toString()
	
	public UserDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public UserDTO(String username, String password, String fullname, String designation, int salary) {
		super();
		this.username = username;
		this.password = password;
		this.fullname = fullname;
		this.designation = designation;
		this.salary = salary;
	}


	public String getUsername() {
		return username;
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


	public String getFullname() {
		return fullname;
	}


	public void setFullname(String fullname) {
		this.fullname = fullname;
	}


	public String getDesignation() {
		return designation;
	}


	public void setDesignation(String designation) {
		this.designation = designation;
	}


	public int getSalary() {
		return salary;
	}


	public void setSalary(int salary) {
		this.salary = salary;
	}


	@Override
	public String toString() {
		return "UserDTO [username=" + username + ", password=" + password + ", fullname=" + fullname + ", designation="
				+ designation + ", salary=" + salary + "]";
	}
	
	

}
