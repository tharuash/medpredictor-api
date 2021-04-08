package com.iit.medpredictor.service;

import com.iit.medpredictor.dto.AuthRequest;
import com.iit.medpredictor.entity.User;
import com.iit.medpredictor.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class AuthService
{

	final UserRepository userRepository;

	public ResponseEntity< User > loginUser( AuthRequest authRequest )
	{
		ResponseEntity<User> response = null;

		Optional<User> optionalUser = userRepository.findUserByUsernameAndAndPassword( authRequest.getUsername(), authRequest.getPassword() );

		if( optionalUser.isPresent() )
		{
			User tempUser = optionalUser.get();
			tempUser.setPassword( "" );
			response = ResponseEntity.status( HttpStatus.FOUND ).body( tempUser );
		}
		else
			{
			response = ResponseEntity.status( HttpStatus.INTERNAL_SERVER_ERROR ).body( null );
		}

		return response;
	}

	public ResponseEntity< User > registerUser( AuthRequest authRequest )
	{
		ResponseEntity<User> response = null;

		if ( !userRepository.existsByUsername( authRequest.getUsername() ) && !userRepository.existsByEmail( authRequest.getEmail() ))
		{
			User user = new User(0L , authRequest.getUsername(), authRequest.getEmail(), authRequest.getPassword(), null);
			User tempUser = userRepository.save( user );
			tempUser.setPassword( "" );
			response = ResponseEntity.status( HttpStatus.CREATED ).body( tempUser );

		}
		else
			{
			response = ResponseEntity.status( HttpStatus.INTERNAL_SERVER_ERROR ).body( null );
		}

		return response;
	}


}
