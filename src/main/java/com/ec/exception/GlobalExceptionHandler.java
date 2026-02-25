package com.ec.exception;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<Map<String, String>> handleIllegalArgument(IllegalArgumentException e) {
		
		HttpStatus status;
		
		switch (e.getMessage()) {
		
			case "USER_NOT_FOUND":
				status = HttpStatus.NOT_FOUND;
				break;
				
			case "PASSWORD_INCORRECT":
				status = HttpStatus.UNAUTHORIZED;
				break;
				
			case "EMAIL_ALREADY_EXISTS":
				status = HttpStatus.CONFLICT;
				break;
				
			default:
				status = HttpStatus.BAD_REQUEST;
		}
		
		return ResponseEntity.status(status).body(Map.of("error", e.getMessage()));
	}
}
