package com.ec.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ec.dto.UserLoginRequest;
import com.ec.dto.UserLoginResponse;
import com.ec.dto.UserRegisterRequest;
import com.ec.dto.UserRegisterResponse;
import com.ec.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	
	private final UserService userService;
	
	public UserController(UserService userService) {
		this.userService = userService;
	}

	@PostMapping("/register")
	public ResponseEntity<UserRegisterResponse> register(@RequestBody UserRegisterRequest dto) {
		
		UserRegisterResponse responseRegister = userService.register(dto);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(responseRegister);
	}
	
	@PostMapping("/login")
	public ResponseEntity<UserLoginResponse> login(@RequestBody UserLoginRequest dto) {
		
		UserLoginResponse responseLogin = userService.login(dto);
		
		return ResponseEntity.ok(responseLogin);
	}
}
