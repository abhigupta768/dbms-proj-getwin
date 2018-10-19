package com.dbms.model;

public class Cart {
	private String username;
	private Long maxq;
	private Long pid;
	private Long qincart;
	private Long price;
	private Long cap;
	private Long pcksize;
	private Long swpsize;
	private String color;
	private Long carea;
	private String name;
	public Cart() {}
	public Cart(String username, Long pid, Long qincart, Long price) {
		this.username=username;
		this.pid=pid;
		this.qincart=qincart;
		this.price=price;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Long getPid() {
		return pid;
	}
	public void setPid(Long pid) {
		this.pid = pid;
	}
	public Long getQincart() {
		return qincart;
	}
	public void setQincart(Long qincart) {
		this.qincart = qincart;
	}
	public Long getPrice() {
		return price;
	}
	public void setPrice(Long price) {
		this.price = price;
	}
	public Long getCap() {
		return cap;
	}
	public void setCap(Long cap) {
		this.cap = cap;
	}
	public Long getPcksize() {
		return pcksize;
	}
	public void setPcksize(Long pcksize) {
		this.pcksize = pcksize;
	}
	public Long getSwpsize() {
		return swpsize;
	}
	public void setSwpsize(Long swpsize) {
		this.swpsize = swpsize;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public Long getCarea() {
		return carea;
	}
	public void setCarea(Long carea) {
		this.carea = carea;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getMaxq() {
		return maxq;
	}
	public void setMaxq(Long maxq) {
		this.maxq = maxq;
	}
	
}
