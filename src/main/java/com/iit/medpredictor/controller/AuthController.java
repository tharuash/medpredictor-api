package com.iit.medpredictor.controller;

import com.iit.medpredictor.dto.AuthRequest;
import com.iit.medpredictor.entity.User;
import com.iit.medpredictor.service.AuthService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping(value = "/auth")
public class AuthController
{
	final AuthService authService;

	@PostMapping(value = "/login")
	public ResponseEntity< User > loginUser(@RequestBody AuthRequest authRequest )
	{
		return authService.loginUser( authRequest );
	}

	@PostMapping(value = "/register")
	public ResponseEntity< User > registerUser(@RequestBody AuthRequest authRequest )
	{
		return authService.registerUser( authRequest );
	}
}
