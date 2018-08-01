package com.web.apps.model;

import org.springframework.stereotype.Component;

@Component
public class Employee {
	
	private String name;
	private String address;
	private String mobile;
	private String emial;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmial() {
		return emial;
	}
	public void setEmial(String emial) {
		this.emial = emial;
	}
	@Override
	public String toString() {
		return "Employee [name=" + name + ", address=" + address + ", mobile=" + mobile + ", emial=" + emial + "]";
	}
	
	
}
