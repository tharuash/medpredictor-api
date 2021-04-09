package com.iit.medpredictor.controller;

import com.iit.medpredictor.service.InitialService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping(value = "/home")
public class InitialController
{
	final InitialService initialService;

	@GetMapping
	public boolean addInitialData(){
		return initialService.addInitialData();
	}

	@DeleteMapping("/{id}")
	public void deleteInitialData( @PathVariable("id") Long orderId ){
		initialService.deleteInitialData( orderId );
	}
}
