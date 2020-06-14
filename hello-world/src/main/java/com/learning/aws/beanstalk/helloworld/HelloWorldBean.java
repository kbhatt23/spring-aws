package com.learning.aws.beanstalk.helloworld;

public class HelloWorldBean {

	private String name;

	public HelloWorldBean(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "HellowRorldBean [name=" + name + "]";
	}

	public void setName(String name) {
		this.name = name;
	}
}
