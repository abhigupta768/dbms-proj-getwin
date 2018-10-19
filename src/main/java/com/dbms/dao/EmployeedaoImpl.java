package com.dbms.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;
//import javax.swing.tree.RowMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.transaction.annotation.Transactional;

import com.dbms.model.Employee;

public class EmployeedaoImpl implements Employeedao{
	
	@Autowired
	DataSource datasource;
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public EmployeedaoImpl() {
		
	}
	
	public EmployeedaoImpl(DataSource datasource) {
		this.jdbcTemplate = new JdbcTemplate(datasource);
	}
	@Transactional
	public void saveOrUpdate(Employee employee) {
		 String sql = "INSERT INTO Userdata(username, password, role) VALUES (?,?,?)";
		 jdbcTemplate.update(sql,new Object[] {employee.getUsername(),employee.getPassword(), "ROLE_EMPLOYEE"});
		 saveOrUpdateEmployee(employee);
		 //System.out.println("EROOR");
		 System.out.println("EROOR");
	}
	@Transactional
	public void delete(String username) {
		String sql = "Delete from Userdata Where username=?";
		jdbcTemplate.update(sql,new Object[] {username});
	}
	@Transactional
	public Employee getEmployeeUser(String username) {
		String sql = "SELECT * FROM Userdata WHERE username='"+username+"'";
		return jdbcTemplate.query(sql,new ResultSetExtractor<Employee>() {
		
		public Employee extractData(ResultSet rs) throws SQLException,DataAccessException{
			if(rs.next()) {
				Employee employee = new Employee();
				employee.setUsername(rs.getString("username"));
				employee.setPassword(rs.getString("password"));
				return employee;
			}
			return null;
		}
		
	});
	}
	@Transactional
	public void saveOrUpdateEmployee(Employee employee) {
		String sql="INSERT INTO Employee(name, address, city, state, pincode, phone_no, username, shift_timings) VALUES(?,?,?,?,?,?,?,?)";
		jdbcTemplate.update(sql,new Object[] {employee.getName(),employee.getAddress(),employee.getCity(),employee.getState(),employee.getPin(),employee.getPhno(),employee.getUsername(),employee.getTimings()});
	}
	@Transactional
	public Employee getEmployee(String username) {
		String sql = "select name,address,city,state,pincode,phone_no,shift_timings,password from Employee,Userdata u WHERE u.username='"+username+"'";
		return jdbcTemplate.query(sql,new ResultSetExtractor<Employee>() {
		
		public Employee extractData(ResultSet rs) throws SQLException,DataAccessException{
			if(rs.next()) {
				Employee employee = new Employee();
//				employee.setUsername(rs.getString("username"));
				employee.setPassword(rs.getString("password"));
				employee.setMpassword(rs.getString("password"));
				employee.setName(rs.getString("name"));
				employee.setAddress(rs.getString("address"));
				employee.setCity(rs.getString("city"));
				employee.setState(rs.getString("state"));
				employee.setPhno(rs.getLong("phone_no"));
				employee.setPin(rs.getLong("pincode"));
				employee.setTimings(rs.getString("shift_timings"));
				return employee;
			}
			return null;
		}
		
	});
		
	}
	@Transactional
	public List<Employee> showEmployee(){
		String sql="select * from Employee";
		List <Employee> allemp=jdbcTemplate.query(sql,new RowMapper<Employee>() {
			@Override
			public Employee mapRow(ResultSet rs, int rowNum) throws SQLException{
				Employee emp = new Employee();
				emp.setUsername(rs.getString("username"));
				emp.setName(rs.getString("name"));
				emp.setAddress(rs.getString("address"));
				emp.setCity(rs.getString("city"));
				emp.setPin(rs.getLong("pincode"));
				emp.setEmp_id(rs.getLong("emp_id"));
				emp.setPhno(rs.getLong("phone_no"));
				emp.setTimings(rs.getString("shift_timings"));
				return emp;
			}
		});
		return allemp;
	}
	@Transactional
	public void empUpdate(Employee employee) {
		String sql="update Employee set name=?,address=?,city=?,state=?,pincode=?,phone_no=?,shift_timings=? where username=?";
		jdbcTemplate.update(sql,new Object[] {employee.getName(), employee.getAddress(), employee.getCity(), employee.getState(), employee.getPin(), employee.getPhno(), employee.getTimings(), employee.getUsername()});
		String sql1="update Userdata set password=? where username=?";
		jdbcTemplate.update(sql1, new Object[] {employee.getPassword(),employee.getUsername()});
		System.out.println("EROOR");
	}
}