package com.itmuch.cloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
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

	@Autowired
	private LoadBalancerClient loadBalancerClient;

	/*
	 * @Autowired private UserClient userClient;
	 */
	@Autowired
	private UserClientSelf userClientSelf;

	@GetMapping("/movie/{id}")
	public User findById(@PathVariable Long id) {
		return this.restTemplate.getForObject("http://microservice-provider-user/simple/" + id, User.class);
	}

	@GetMapping("/test")
	public int test() {
		ServiceInstance serviceInstance = this.loadBalancerClient.choose("microservice-provider-user");
		System.out.println(serviceInstance.getServiceId()+"::"+serviceInstance.getHost()+":"+serviceInstance.getPort());
		
		ServiceInstance serviceInstance2 = this.loadBalancerClient.choose("microservice-provider-user2");
		System.out.println(serviceInstance2.getServiceId()+"::"+serviceInstance2.getHost()+":"+serviceInstance2.getPort());
		return 1;
	}

	/*
	 * 11
	 * 
	 * @GetMapping("/movie/{id}") public User findById(@PathVariable Long id) {
	 * return this.userClient.findById(id); }
	 */
	/*
	 * @GetMapping("/movie/{id}") public User findById(@PathVariable Long id) {
	 * return this.userClientSelf.findById(id); }
	 */
}
