package com.blogs.dto;

import java.time.LocalDate;

public class UserRespDTO extends BaseDTO{
	private String firstName;
	private String lastName;
	private LocalDate dob;
	private String phoneNo;
	
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
	public LocalDate getDob() {
		return dob;
	}
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public UserRespDTO(String firstName, String lastName, LocalDate dob, String phoneNo) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
		this.phoneNo = phoneNo;
	}
	@Override
	public String toString() {
		return "UserRespDTO [firstName=" + firstName + ", lastName=" + lastName + ", dob=" + dob + ", phoneNo="
				+ phoneNo + "]";
	}
	
	

}
