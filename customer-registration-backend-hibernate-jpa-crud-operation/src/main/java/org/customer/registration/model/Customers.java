package org.customer.registration.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "customerstbl")
public class Customers {
	
	@Id
	@Column(name = "id")
	private long id;
	
	@Column(name = "f_name")
	private String fname;
	
	@Column(name = "l_name")
	private String lname;
	
	@Column(name = "age")
	private Integer age;
	
	@Column(name = "gender")
	private String gender;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "registration_date")
	private LocalDate registrationDate;
	
	public Customers() {
		
	}
	
	public Customers(long id, String fname, String lname, Integer age, String gender, String email,
			LocalDate registrationDate) {
		this.id = id;
		this.fname = fname;
		this.lname = lname;
		this.age = age;
		this.gender = gender;
		this.email = email;
		this.registrationDate = registrationDate;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public LocalDate getRegistrationDate() {
		return registrationDate;
	}
	public void setRegistrationDate(LocalDate registrationDate) {
		this.registrationDate = registrationDate;
	}
	
	
}
