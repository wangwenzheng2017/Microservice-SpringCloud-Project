package com.itmuch.cloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.itmuch.cloud.entity.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class MovieController {
	@Autowired
	private RestTemplate restTemplate;

	@GetMapping("/movie/{id}")
	@HystrixCommand(fallbackMethod = "fallback")
	public User findById(@PathVariable Long id) {
		return this.restTemplate.getForObject("http://microservice-provider-user/simple/" + id, User.class);
	}
	
	@GetMapping("/movie2/{id}")
	@HystrixCommand(fallbackMethod = "fallback")
	public User findById2(@PathVariable Long id) {
		return this.restTemplate.getForObject("http://microservice-provider-user2/simple/" + id, User.class);
	}

	public User fallback(Long id) {
		User user = new User();
		user.setId(0l);
		return user;
	}
}
