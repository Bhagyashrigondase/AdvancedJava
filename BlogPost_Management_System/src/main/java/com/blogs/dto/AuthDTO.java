package com.blogs.dto;

public class AuthDTO {
	private String email;
	private String pwd;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	@Override
	public String toString() {
		return "AuthDTO [email=" + email + ", pwd=" + pwd + "]";
	}
	public AuthDTO(String email, String pwd) {
		super();
		this.email = email;
		this.pwd = pwd;
	}
	

}
