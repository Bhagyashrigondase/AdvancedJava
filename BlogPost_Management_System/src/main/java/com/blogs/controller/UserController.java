package com.blogs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blogs.dto.ApiResponse;
import com.blogs.dto.AuthDTO;
import com.blogs.dto.UserRespDTO;
import com.blogs.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	/*
	 * Authenticate user
	 * URL : http://host:port/users/signin
	 * Method:POST (For security)
	 * Request: AuthDTO (email,password)
	 * Response:Success->ResponseDTO(fname,lname,phoneNo,DOB)
	 * Failed ->ApiResponse ->Error msg
	 *
	 * 
	 */
	
	@PostMapping("/signin")
	public ResponseEntity<?> signInUser(@RequestBody AuthDTO dto)
	{
		System.out.println("In authenticate user "+dto);
		try {
		UserRespDTO respdto=userService.authenticateUser(dto);
		return ResponseEntity.ok(respdto); //It will create ResponseEntity Package
		}catch (RuntimeException e) {
			System.out.println(e);
			//Resp -->SC 404 ApiResponse with error msg
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
			.body(new ApiResponse(e.getMessage()));
		}
	}

}
