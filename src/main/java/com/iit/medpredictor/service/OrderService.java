package com.iit.medpredictor.service;

import com.iit.medpredictor.dto.AuthRequest;
import com.iit.medpredictor.entity.Order;
import com.iit.medpredictor.entity.User;
import com.iit.medpredictor.repository.OrderRepository;
import com.iit.medpredictor.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class OrderService
{
	final OrderRepository orderRepository;

	final UserRepository userRepository;

	public ResponseEntity< Order > createOrder( Order order, Long userId )
	{
		ResponseEntity<Order> response = null;

		Optional<User> optionalUser = userRepository.findById( userId );

		if( optionalUser.isPresent() )
		{
			User tempUser = optionalUser.get();
			order.setUser( tempUser );

			Order savedOrder = orderRepository.save( order );
			response = ResponseEntity.status( HttpStatus.CREATED ).body( order );
		}
		else
		{
			response = ResponseEntity.status( HttpStatus.INTERNAL_SERVER_ERROR ).body( null );
		}

		return response;
	}

	public ResponseEntity< List<Order> > getLast100Orders()
	{
		ResponseEntity<List <Order> > response = null;

		try{



		}

		if( optionalUser.isPresent() )
		{
			User tempUser = optionalUser.get();
			order.setUser( tempUser );

			Order savedOrder = orderRepository.save( order );
			response = ResponseEntity.status( HttpStatus.CREATED ).body( order );
		}
		else
		{
			response = ResponseEntity.status( HttpStatus.INTERNAL_SERVER_ERROR ).body( null );
		}

		return response;
	}
}
