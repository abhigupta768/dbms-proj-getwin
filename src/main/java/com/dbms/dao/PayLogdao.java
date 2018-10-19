package com.dbms.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.dbms.model.PayLog;

public interface PayLogdao {
	@Autowired
	public void updateELog(PayLog paylog);
	public void updateMLog(PayLog paylog);
	public List<PayLog> displog();
}
