package com.itmuch.cloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.itmuch.cloud.entity.User;
import com.itmuch.cloud.feign.UserClient;
import com.itmuch.cloud.feign.UserClientSelf;

@RestController
public class MovieController {
  @Autowired
  private RestTemplate restTemplate;

  @Value("${user.userServicePath}")
  private String userServicePath;
  
	/*
	 * @Autowired private UserClient userClient;
	 */
  @Autowired
  private UserClientSelf userClientSelf;

	/*
	 * @GetMapping("/movie/{id}") public User findById(@PathVariable Long id) {
	 * return this.restTemplate.getForObject(this.userServicePath + id, User.class);
	 * }
	 */
  
	/* 11
	 * @GetMapping("/movie/{id}") public User findById(@PathVariable Long id) {
	 * return this.userClient.findById(id); }
	 */
  @GetMapping("/movie/{id}")
  public User findById(@PathVariable Long id) {
	  return this.userClientSelf.findById(id);
  }
}
