package com.dbms.model;

import java.sql.Date;

public class Invoice {
	private Long invid;
	private String username;
	private Date dog;
	private Long amount;
	private Long pid;
	private Long qinentry;
	private Long price;
	public Invoice() {}
	public Invoice(Long invid,String username, Date dog, Long amount, Long pid, Long qinentry, Long price) {
		this.invid=invid;
		this.username=username;
		this.dog=dog;
		this.amount=amount;
		this.pid=pid;
		this.qinentry=qinentry;
		this.price=price;
	}
	public Long getInvid() {
		return invid;
	}
	public void setInvid(Long invid) {
		this.invid = invid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Date getDog() {
		return dog;
	}
	public void setDog(Date dog) {
		this.dog = dog;
	}
	public Long getAmount() {
		return amount;
	}
	public void setAmount(Long amount) {
		this.amount = amount;
	}
	public Long getPid() {
		return pid;
	}
	public void setPid(Long pid) {
		this.pid = pid;
	}
	public Long getQinentry() {
		return qinentry;
	}
	public void setQinentry(Long qinentry) {
		this.qinentry = qinentry;
	}
	public Long getPrice() {
		return price;
	}
	public void setPrice(Long price) {
		this.price = price;
	}
	
}
