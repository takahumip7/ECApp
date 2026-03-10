package com.ec.dto;

public class UserLoginResponse {

	private Long id;
	private String name;
	private String email;
	private String token;
	
	public UserLoginResponse(Long id, String name, String email, String token) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.token = token;
	}
	
	public Long getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getEmail() {
		return email;
	}
	public String getToken() {
		return token;
	}	
}
