package com.itmuch.cloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestTemplate;

public class MovieControllerData {
	@Autowired
	public RestTemplate restTemplate;
	@Value("${user.userServicePath}")
	public String userServicePath;

	public MovieControllerData() {
	}
}