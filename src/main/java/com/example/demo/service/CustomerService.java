package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.example.demo.model.Customer;

@Service
public class CustomerService {
	
	@Value("${topic.name}")
	String topicName;
	
	@Autowired
	KafkaTemplate<String, Customer>  kafkaTemplate;
	
	public String addCustomer(Customer customer) {
		kafkaTemplate.send(topicName, "spring", customer);
		return "customer added to kafka topic successfully!";
	}

}
