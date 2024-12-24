package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Customer;
import com.example.demo.service.CustomerService;

@RestController
public class CustomerController {
	@Autowired
	CustomerService customerService;
	
	@PostMapping( value = "/publish")
	public ResponseEntity<String> publishMessage(@RequestBody Customer customer) {
		String result = customerService.addCustomer(customer);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
}
