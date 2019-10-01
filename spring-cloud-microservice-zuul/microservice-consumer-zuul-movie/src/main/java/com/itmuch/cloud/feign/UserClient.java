package com.itmuch.cloud.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.itmuch.cloud.entity.User;

//@FeignClient("microservice-provider-user")
public interface UserClient {

//	@RequestMapping(value="/simple/{id}",method = RequestMethod.GET, consumes = "application/json")
//	public User findById(@PathVariable("id") Long id);
	
}
