package com.learning.aws.beanstalk.employeesystem;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Employee {
	@Id
	// when using spring jpa id should be auto generated
	@GeneratedValue
	private Integer id;
	private String name;
	private boolean isFootballFan;
	private String favouriteGod;

	public Employee() {
		super();
	}

	public Employee(String name, boolean isFootballFan, String favouriteGod) {
		super();
		this.name = name;
		this.isFootballFan = isFootballFan;
		this.favouriteGod = favouriteGod;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isFootballFan() {
		return isFootballFan;
	}

	public void setFootballFan(boolean isFootballFan) {
		this.isFootballFan = isFootballFan;
	}

	public String getFavouriteGod() {
		return favouriteGod;
	}

	public void setFavouriteGod(String favouriteGod) {
		this.favouriteGod = favouriteGod;
	}

	public Integer getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", isFootballFan=" + isFootballFan + ", favouriteGod="
				+ favouriteGod + "]";
	}
}
