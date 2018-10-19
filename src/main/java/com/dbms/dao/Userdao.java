package com.dbms.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.dbms.model.User;

public interface Userdao{
	@Autowired
	public void saveOrUpdate(User user);
	public void delete(String username);
	public User getUser(String username);
	public User getCustomer(String username);
	public void saveOrUpdateCustomer(User user);
	public String findRole(String username);
	public void userUpdate(User user);
	public List<User> showUser(String username);
}