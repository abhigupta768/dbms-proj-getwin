package com.dbms.model;

import org.hibernate.validator.constraints.NotEmpty;

public class Product {
	@NotEmpty(message="required")
	private String name;
	private Long mid;
	private Long wid;
	private long product_id;
	public long getProduct_id() {
		return product_id;
	}
	public void setProduct_id(long product_id) {
		this.product_id = product_id;
	}
	private String type;
	@NotEmpty(message="required")
	private String hsncode;
	private Long qinstock;
	private Long price;
	private Long cap;
	private Long pcksize;
	private Long swpsize;
	private String color;
	private Long carea;
	public Product() {}
	public Product(String name, Long mid, String color,  String type, String hsncode, Long price, Long qinstock, Long pcksize, Long carea, Long cap,Long swpsize, Long product_id) {
		this.name=name;
		this.mid=mid;
		this.color=color;
		this.type=type;
		this.hsncode=hsncode;
		this.price=price;
		this.qinstock=qinstock;
		this.pcksize=pcksize;
		this.carea=carea;
		this.cap=cap;
		this.swpsize=swpsize;
		this.product_id=product_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getMid() {
		return mid;
	}
	public void setMid(Long mid) {
		this.mid = mid;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getHsncode() {
		return hsncode;
	}
	public void setHsncode(String hsncode) {
		this.hsncode = hsncode;
	}
	public Long getQinstock() {
		return qinstock;
	}
	public void setQinstock(Long qinstock) {
		this.qinstock = qinstock;
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
	public Long getWid() {
		return wid;
	}
	public void setWid(Long wid) {
		this.wid = wid;
	}
	
}
