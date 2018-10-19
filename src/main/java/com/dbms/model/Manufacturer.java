package com.dbms.model;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

public class Manufacturer {
	@NotEmpty(message="required")
	private String name;
	private String website;
	private String address;
	//@NotEmpty(message="required")
	private Long mid;
	public Long getMid() {
		return mid;
	}
	public void setMid(Long mid) {
		this.mid = mid;
	}
	private Long pin;
	private String city;
	private String state;
	private Long phno;
	@NotEmpty(message="required")
	@Email(message="Invalid mail")
	private String email;
	
	public Manufacturer() {
		
	}
	public Manufacturer(String name, String website, Long credit, Long debit, String address, Long pin, String city, String state,Long phno, String email) {
		this.name=name;
		this.website=website;
		this.city=city;
		this.address=address;
		this.pin=pin;
		this.state=state;
		this.phno=phno;
		this.email=email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Long getPin() {
		return pin;
	}
	public void setPin(Long pin) {
		this.pin = pin;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public Long getPhno() {
		return phno;
	}
	public void setPhno(Long phno) {
		this.phno = phno;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
