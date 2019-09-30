package com.itmuch.cloud.feign;

import org.springframework.cloud.netflix.feign.FeignClient;

import com.itmuch.cloud.config.FeignConfig;
import com.itmuch.cloud.entity.User;

import feign.Param;
import feign.QueryMap;
import feign.RequestLine;

@FeignClient(name = "microservice-provider-user", configuration = FeignConfig.class)
public interface UserClientSelf {

//	@RequestLine("GET /simple/{id}")
//	public User findById(@Param("id") Long id);
	
	//@SpringQueryMap user in spring cloud 2.1.x
	@RequestLine("GET /simple/{id}")
	public User findById(@Param("id") Long id);
	
}
