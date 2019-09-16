package com.itmuch.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.itmuch.cloud.config.RibbonConfig;

@SpringBootApplication
@EnableEurekaClient
//@RibbonClient(name = "microservice-provider-user")
public class MicroserviceSimpleConsumerRibbonMovieWithoutEurekaApplication {

  @Bean
  @LoadBalanced
  public RestTemplate restTemplate() {
    return new RestTemplate();
  }

  public static void main(String[] args) {
    SpringApplication.run(MicroserviceSimpleConsumerRibbonMovieWithoutEurekaApplication.class, args);
  }
}
