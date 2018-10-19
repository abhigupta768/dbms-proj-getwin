package com.dbms.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.dbms.model.Employee;
public interface Employeedao {
	@Autowired
	public void saveOrUpdate(Employee employee);
	public void delete(String username);
	public Employee getEmployeeUser(String username);
	public Employee getEmployee(String username);
	public void saveOrUpdateEmployee(Employee employee);
	public List<Employee> showEmployee();
	public void empUpdate(Employee employee);
}
