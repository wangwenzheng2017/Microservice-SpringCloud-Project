package com.itmuch.cloud.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;

public class RibbonConfig {
	
	@Autowired
	IClientConfig config;

	@Bean
	public IRule ribbonRule(IClientConfig config) {
		return new RandomRule();
	}
}
