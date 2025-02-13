package com.yedam.app.spring.xml;

public class User {
	private String name;
	private String ssn;
	
	User() {
		this.name = "Hong";
		this.ssn = "123456";
	}
	User(String name, String ssn) {
		this.name = name;
		this.ssn = ssn;
	}

	public void setName(String name) {
		this.name = name;
	}
	public void setSsn(String ssn) {
		this.ssn = ssn;
	}
	@Override
	public String toString() {
		return "User [name=" + name + ", ssn=" + ssn + "]";
	}
}
