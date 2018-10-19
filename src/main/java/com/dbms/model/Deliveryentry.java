package com.dbms.model;

import java.sql.Date;

public class Deliveryentry {
	private Long pincode;
	private Long phno;
	private String address;
	private String city;
	private String state;
	private String username;
	private Date dod;
	private Long dsid;
	private String isdelivered;
	private Long invid;
	public Long getPincode() {
		return pincode;
	}
	public void setPincode(Long pincode) {
		this.pincode = pincode;
	}
	public Long getPhno() {
		return phno;
	}
	public void setPhno(Long phno) {
		this.phno = phno;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
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
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Date getDod() {
		return dod;
	}
	public void setDod(Date dod) {
		this.dod = dod;
	}
	public Long getDsid() {
		return dsid;
	}
	public void setDsid(Long dsid) {
		this.dsid = dsid;
	}
	public String getIsdelivered() {
		return isdelivered;
	}
	public void setIsdelivered(String isdelivered) {
		this.isdelivered = isdelivered;
	}
	public Long getInvid() {
		return invid;
	}
	public void setInvid(Long invid) {
		this.invid = invid;
	}
	
}
