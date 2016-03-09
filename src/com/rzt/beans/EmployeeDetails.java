	package com.rzt.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.UniqueConstraint;

@Entity
public class EmployeeDetails {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int employeeId;
	private String firstName ="";
	private String lastName="";
	private int password ;
	private int age=0;
	@Column(name = "email",unique = true)
	private String email = "";
	
	public void setEmployeeId(int employeeId)
	{
		this.employeeId = employeeId;
	}
	public int getEmployeeId()
	{
		return employeeId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getPassword() {
		return password;
	}
	public void setPassword(String password) {
		int hash = password.hashCode();
		hash = hash + 65656;
		this.password =hash;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	

}
