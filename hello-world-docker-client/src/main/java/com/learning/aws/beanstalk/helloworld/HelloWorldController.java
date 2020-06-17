package com.learning.aws.beanstalk.helloworld;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class HelloWorldController {
	private final static Logger logger = LoggerFactory.getLogger(HelloWorldController.class);

	@Value("${HELLO_WORLD_HOST:localhost}")
	private String helloWorldHost;

	private RestTemplate restTemplate = new RestTemplate();

	@GetMapping("/hello-world-client")
	public String helloWorldClient() {
		logger.info("helloWorldClient():hello-world-client API called");
		String helloWorldUrl = "http://" + helloWorldHost + ":5000/hello-world";
		logger.info("helloWorldClient():hello-world URL  "+ helloWorldUrl);
		ResponseEntity<String> response = restTemplate.getForEntity(helloWorldUrl, String.class);
		String  body = response.getBody();
		logger.info("helloWorldClient():hello-world response  "+ body);
		return  body;
	}
}
