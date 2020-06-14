package com.learning.aws.beanstalk.helloworld;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
	private final static Logger logger = LoggerFactory.getLogger(HelloWorldController.class);

	@GetMapping("/hello-world")
	public String helloWorld() {
		logger.info("helloWorld():hello-world API called");
		return "hello world";
	}

	@GetMapping("/hello-world-bean")
	public HelloWorldBean helloWorldBean() {
		logger.info("helloWorldBean():hello-world-bean API called");
		return new HelloWorldBean("hello world");
	}

	@GetMapping("/hello-world-path/{name}")
	public HelloWorldBean helloWorldBeanPath(@PathVariable String name) {
		logger.info("helloWorldBeanPath():hello-world-path API called with name "+name);
		return new HelloWorldBean("hello world " + name);
	}
}
