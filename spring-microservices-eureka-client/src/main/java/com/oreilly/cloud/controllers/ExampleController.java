package com.oreilly.cloud.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ExampleController {
	
	private static final Logger logger = LoggerFactory.getLogger(ExampleController.class);

	@Value("${server.port}")
	String port;
	
	@Autowired
	RestTemplate restTemplate;
	
	@RequestMapping("/execute")
	public String execute() {
		logger.info("In the execute method of "+port);
		return restTemplate.getForObject("http://myOtherClient/serviceInfo", String.class);
	}
	
}
