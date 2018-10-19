package com.dbms.model;

import java.sql.Date;

public class PayLog {
	private Long emp_id;
	private Long man_id;
	private Long amount;
	private Date dop;
	private String ptype;
	private Long payid;
	public Long getPayid() {
		return payid;
	}

	public void setPayid(Long payid) {
		this.payid = payid;
	}

	public PayLog() {
		
	}

	public Long getEmp_id() {
		return emp_id;
	}

	public void setEmp_id(Long emp_id) {
		this.emp_id = emp_id;
	}

	public Long getMan_id() {
		return man_id;
	}

	public void setMan_id(Long man_id) {
		this.man_id = man_id;
	}

	public Long getAmount() {
		return amount;
	}

	public void setAmount(Long amount) {
		this.amount = amount;
	}

	public Date getDop() {
		return dop;
	}

	public void setDop(Date dop) {
		this.dop = dop;
	}

	public String getPtype() {
		return ptype;
	}

	public void setPtype(String ptype) {
		this.ptype = ptype;
	}
	
	
}
