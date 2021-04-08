package com.iit.medpredictor.controller;

import com.iit.medpredictor.entity.Order;
import com.iit.medpredictor.entity.type.Medicine;
import com.iit.medpredictor.service.OrderService;
import com.iit.medpredictor.utils.ResponseWrapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping(value = "/orders")
public class OrderController
{
	final OrderService orderService;

	@GetMapping("/{medicine}")
	public ResponseEntity< ResponseWrapper > getLast50Orders( @PathVariable("medicine") Medicine medicine )
	{
		return orderService.getLast50Orders(medicine);
	}

	@PostMapping
	public ResponseEntity< ResponseWrapper > createOrder( @RequestBody Order order, @RequestParam("uid") Long userId )
	{
		return orderService.createOrder( order, userId );
	}

}
