package com.oreilly.cloud;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.discovery.EurekaClient;

import brave.sampler.Sampler;

@RestController
@EnableEurekaClient  // or EnableDiscoveryClient 
@SpringBootApplication
public class SpringMicroservicesEurekaClient2Application {

	private static final Logger logger = LoggerFactory.getLogger(SpringMicroservicesEurekaClient2Application.class);
	
	@Value("${server.port}")
	String port;
	
	@Bean
	public Sampler defaultSampler() {
		return Sampler.ALWAYS_SAMPLE;
	}
	
	@Autowired
	private EurekaClient client;
	
	@RequestMapping("/serviceInfo")
	public String serviceInfo() {
		logger.info("In the serviceInfo method of "+port);
		//InstanceInfo instance = client.getNextServerFromEureka("myClient", false);
		return "Hello From "+ port;
	}
	
	public static void main(String[] args) {
		SpringApplication.run(SpringMicroservicesEurekaClient2Application.class, args);
	}

}
