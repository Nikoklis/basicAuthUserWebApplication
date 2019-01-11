package com.nk.authApp.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name="Users")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotNull(message="Email can not be empty")
	@NotBlank(message="Email can not be empty")
	@Email
	@Column(name = "email")
	private String email;
	
	@NotNull(message = "Password can not be empty")
	
	@Size(min = 8, message = "Password size must be at least {min} characters long")
	@Pattern(regexp = ".*[0-9].*",message = "Password must contain at least one number")
	@Pattern(regexp = ".*[a-z].*",message = "Password must contain at least one lowercase character")
	@Pattern(regexp = ".*[A-Z].*",message = "Password must contain at least one uppercase character")
	@Pattern(regexp = ".*[@#$%^&+=!].*" , message = "Password must contain at least one special character")
	@Column(name = "password")
	private String password;
 
	@Column(name = "firstname")
	private String firstName;
 
	@Column(name = "lastname")
	private String lastName;
	
	@Column(name = "phonenumber")
	private String phoneNumber;
	
	@Column(name = "companyname")
	private String companyName;
	
	@Transient 
	private String verify;
	
	protected User() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	
	public void setVerify(String verify)
	{
		this.verify = verify;
	}
	
	
	public String getVerify()
	{
		return this.verify;
	}

}
